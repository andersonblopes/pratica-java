package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchase_order")
public class Order {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @Column(name = "invoice_id")
    private Integer invoiceId;

    private BigDecimal total;

    @Column(name = "order_status")
    private OrderStatus orderStatus;
}
