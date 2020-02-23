package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Order {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private LocalDateTime orderDate;
    private LocalDateTime finishDate;
    private Integer invoiceId;
    private BigDecimal total;
    private OrderStatus orderStatus;
}
