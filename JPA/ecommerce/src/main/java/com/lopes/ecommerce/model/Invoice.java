package com.lopes.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "invoice")
public class Invoice {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "order_id")
    //@JoinTable(name = "order_invoice", joinColumns = @JoinColumn(name = "invoice_id", unique = true),
    //        inverseJoinColumns = @JoinColumn(name = "order_id", unique = true))
    private Order order;

    private String xml;

    @Column(name = "issue_date")
    private Date issueDate;
}
