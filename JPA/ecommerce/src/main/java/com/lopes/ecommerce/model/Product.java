package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

}
