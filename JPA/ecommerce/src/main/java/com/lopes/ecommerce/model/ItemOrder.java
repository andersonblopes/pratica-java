package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ItemOrder {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String orderId;
    private Integer productId;
    private BigDecimal productPrice;
    private Integer amount;
}
