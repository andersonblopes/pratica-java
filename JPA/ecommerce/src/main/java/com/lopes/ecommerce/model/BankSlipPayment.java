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
@Table(name = "Bank_slip_payment")
public class BankSlipPayment {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "bar_code")
    private String barCode;

}
