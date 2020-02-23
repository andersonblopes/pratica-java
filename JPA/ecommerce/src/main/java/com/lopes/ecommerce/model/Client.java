package com.lopes.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class Client {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
