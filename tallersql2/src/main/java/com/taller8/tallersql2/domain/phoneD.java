package com.taller8.tallersql2.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "phone")
public class phoneD implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;

    @Column(name = "phone_operator")
    private String Operator;

    @Column(name = "phone_number")
    private BigInteger number;

    @Column(name = "phone_owner")
    private String owner;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = contactD.class, mappedBy = "phone", cascade = CascadeType.REMOVE)
    private List<contactD> contacts = new ArrayList<>();
}
