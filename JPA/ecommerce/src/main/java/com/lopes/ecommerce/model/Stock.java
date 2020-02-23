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
@Table(name = "stock")
public class Stock {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private Integer amount;
}
