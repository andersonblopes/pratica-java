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
public class BankSlipPayment {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer orderId;
    private PaymentStatus paymentStatus;
    private String barCode;

}
