package com.taller8.tallersql2.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "contact")

public class contactD implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long Id;

    @Column(name = "contact_name")
    private String Name;

    @Column(name = "contact_email")
    private String Email;

    @Column(name = "contact_number")
    private BigInteger Number;

    @Column(name = "contact_date")
    private Date Date;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = phoneD.class, optional = false)
    @JoinColumn(name = "phone_id")
    @JsonBackReference
    private phoneD phone;

}
