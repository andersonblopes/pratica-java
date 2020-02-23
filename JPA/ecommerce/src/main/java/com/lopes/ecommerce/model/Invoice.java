package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Invoice {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer orderId;
    private String xml;
    private Date issueDate;
}
