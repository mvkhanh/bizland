package com.javaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<BuildingEntity> findAll(BuildingSearchRequest searchDTO, Pageable pageable) {
        String baseQuery = "FROM building b " + getQuery(searchDTO);
        Query query = entityManager.createNativeQuery("SELECT DISTINCT * " + baseQuery, BuildingEntity.class);
        Query countQuery = entityManager.createNativeQuery("SELECT COUNT(DISTINCT b.id) " + baseQuery);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return new PageImpl<>(query.getResultList(), pageable, ((Number) countQuery.getSingleResult()).longValue());
    }

    private StringBuilder getQuery(BuildingSearchRequest searchDTO) {
        StringBuilder query = new StringBuilder(" WHERE 1 = 1 ");
        try {
            for(Field field : searchDTO.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(searchDTO);
                if(value == null || !StringUtil.checkString(value.toString()) || field.getName().equals("pageNumber") || field.getName().equals("pageSize")) continue;
                if(!field.getName().equals("id_staff") && !field.getName().equals("typeCodes") && !field.getName().startsWith("area") && !field.getName().startsWith("rentPrice")) {
                    if(!field.getName().equals("managerPhone") && NumberUtil.checkNumber(value.toString())) query.append(" AND b.").append(field.getName()).append(" = ").append(value);
                    else query.append(" AND b.").append(field.getName()).append(" LIKE '%").append(value).append("%'");
                }
                else query.append(specialQuery(field, searchDTO));
            }
        }
        catch (Exception e) {
            e.getMessage();
        }
        return query;
    }

    private StringBuilder specialQuery(Field field, BuildingSearchRequest searchDTO) {
        StringBuilder specQuery = new StringBuilder();
        switch (field.getName()) {
            case "id_staff":
                specQuery.append(" AND EXISTS (SELECT * FROM buildingassignment WHERE id_building = b.id AND id_user = ")
                        .append(searchDTO.getId_staff()).append(")");
                break;

            case "areaFrom":
                specQuery.append(" AND EXISTS (SELECT id FROM rentarea WHERE id_building = b.id AND value >= ")
                        .append(searchDTO.getAreaFrom()).append(" LIMIT 1)");
                break;

            case "areaTo":
                specQuery.append(" AND EXISTS (SELECT id FROM rentarea WHERE id_building = b.id AND value <= ")
                        .append(searchDTO.getAreaTo()).append(" LIMIT 1)");
                break;

            case "rentPriceFrom":
                specQuery.append(" AND rentprice >= ").append(searchDTO.getRentPriceFrom());
                break;

            case "rentPriceTo":
                specQuery.append(" AND rentprice <= ").append(searchDTO.getRentPriceTo());
                break;

            case "typeCodes":
                if (!searchDTO.getTypeCodes().isEmpty()) {
                    specQuery.append(" AND (1 = 0");
                    searchDTO.getTypeCodes().forEach(i -> specQuery.append(" OR typecodes REGEXP '(^|,)").append(i).append("(,|$)' "));
                    specQuery.append(")");
                }
                break;

            default:
                break;
        }
        return specQuery;
    }
}