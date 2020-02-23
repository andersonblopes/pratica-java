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
@Table(name = "credit_card_payment")
public class CreditCardPayment {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    private String number;

}
