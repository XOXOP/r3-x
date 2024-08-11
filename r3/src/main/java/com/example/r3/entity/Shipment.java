package com.example.r3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@Entity
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "shipment")
@Getter
@Setter
public class Shipment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String recipientName;

    @Column
    private String type; // "letter", "package", "parcel", "postcard"
    @Column
    private String recipientIndex;
    @Column
    private String recipientAddress;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status; // "registered", "in transit", "delivered",

    public Shipment() {
    }

    ;

    public Shipment(Long id, String recipientName, String type, String recipientIndex, String recipientAddress,
                    Status status) {
        this.id = id;
        this.recipientName = recipientName;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.status = status;
    }
}




