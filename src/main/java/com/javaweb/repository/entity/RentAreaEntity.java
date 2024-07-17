package com.javaweb.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity{

    private Integer value;

    @ManyToOne
    @JoinColumn(name = "id_building")
    private BuildingEntity building;
}