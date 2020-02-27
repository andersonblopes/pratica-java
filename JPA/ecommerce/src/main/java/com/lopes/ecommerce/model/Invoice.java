package com.lopes.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    @OneToOne(optional = false) // Optional = false --> JPA execute inner join instead left outer join)
    @JoinColumn(name = "order_id")
    //@JoinTable(name = "order_invoice", joinColumns = @JoinColumn(name = "invoice_id", unique = true),
    //        inverseJoinColumns = @JoinColumn(name = "order_id", unique = true))
    private Order order;

    private String xml;

    @Column(name = "issue_date")
    private Date issueDate;
}
