package com.lopes.ioc.model;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal total;

    public Product(String name, BigDecimal total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
