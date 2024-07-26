package com.javaweb.repository.custom.impl;

import com.javaweb.repository.custom.RepositoryCustom;
import com.javaweb.utils.NumberUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class RepositoryCustomImpl <E, S> implements RepositoryCustom<E, S> {
    @PersistenceContext
    private EntityManager entityManager;

    private String table;

    private String getEntityName(Object obj) {
        String className = obj.getClass().getSimpleName();
        return className.substring(0, className.indexOf("SearchRequest")).toLowerCase();
    }

    @Override
    public Page<E> findAll(S searchDTO, Pageable pageable, Class<E> entityClass) {
        table = getEntityName(searchDTO);
        String baseQuery = " FROM " + table + " b " + getQuery(searchDTO);
        Query query = entityManager.createNativeQuery("SELECT DISTINCT * " + baseQuery, entityClass);
        Query countQuery = entityManager.createNativeQuery("SELECT COUNT(DISTINCT b.id) " + baseQuery);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return new PageImpl<>(query.getResultList(), pageable, ((Number) countQuery.getSingleResult()).intValue());
    }

    private StringBuilder getQuery(S searchDTO) {
        StringBuilder query = new StringBuilder(" WHERE 1 = 1 ");
        try {
            for(Field field : searchDTO.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(searchDTO);
                if(value == null || !StringUtils.hasText(value.toString()) || field.getName().equals("pageNumber") || field.getName().equals("pageSize")) continue;
                if(!field.getName().equals("id_staff") && !field.getName().equals("typeCodes") && !field.getName().startsWith("area") && !field.getName().startsWith("rentPrice")) {
                    if(!field.getName().toLowerCase().contains("phone") && NumberUtil.checkNumber(value.toString())) query.append(" AND b.").append(field.getName()).append(" = ").append(value);
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

    private StringBuilder specialQuery(Field field, S searchDTO) throws IllegalAccessException {
        StringBuilder specQuery = new StringBuilder();
        field.setAccessible(true);
        Object value = field.get(searchDTO);
        switch (field.getName()) {
            case "id_staff":
                specQuery.append(" AND EXISTS (SELECT * FROM " + table + "assignment WHERE id_" + table + " = b.id AND id_staff = ")
                        .append(value).append(")");
                break;

            case "areaFrom":
                specQuery.append(" AND EXISTS (SELECT id FROM rentarea WHERE id_" + table + " = b.id AND value >= ")
                        .append(value).append(" LIMIT 1)");
                break;

            case "areaTo":
                specQuery.append(" AND EXISTS (SELECT id FROM rentarea WHERE id_" + table + " = b.id AND value <= ")
                        .append(value).append(" LIMIT 1)");
                break;

            case "rentPriceFrom":
                specQuery.append(" AND rentprice >= ").append(value);
                break;

            case "rentPriceTo":
                specQuery.append(" AND rentprice <= ").append(value);
                break;

            case "typeCodes":
                List<String> typeCodes = (List<String>) value;
                if (!typeCodes.isEmpty()) {
                    specQuery.append(" AND (1 = 0");
                    typeCodes.forEach(i -> specQuery.append(" OR typecodes REGEXP '(^|,)").append(i).append("(,|$)' "));
                    specQuery.append(")");
                }
                break;

            default:
                break;
        }
        return specQuery;
    }
}
