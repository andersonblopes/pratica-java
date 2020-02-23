package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "category")
public class Category {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String name;

    @Column(name = "category_main_id")
    private Integer categoryMainId;
}
