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

@Table(name = "shipment")
//@Getter
//@Setter
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
    private int recipientIndex;
    @Column
    private String recipientAddress;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status; // "registered", "in transit", "delivered",

    public Shipment() {
    }

    ;

    public Shipment(Long id, String recipientName, String type, int recipientIndex, String recipientAddress,
                    Status status) {
        this.id = id;
        this.recipientName = recipientName;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRecipientIndex() {
        return recipientIndex;
    }

    public void setRecipientIndex(int recipientIndex) {
        this.recipientIndex = recipientIndex;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}




