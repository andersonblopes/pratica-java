package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Stock {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer productId;
    private Integer amount;
}
