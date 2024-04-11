package com.masala.indianSpices.Dto;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "contact_no")
    private String contactNo;

    @NonNull
    @Column(name = "email")
    private String email;
}
