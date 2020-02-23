package com.lopes.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class DeliveryAddress {

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "address_line_2")
    private String addressLine2;

    private String city;

    @Column(name = "state_province_region")
    private String StateProvinceRegion;

    @Column(name = "postal_zip_code")
    private String postalZipCode;
}
