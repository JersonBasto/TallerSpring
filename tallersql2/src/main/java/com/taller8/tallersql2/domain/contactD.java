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

/**
 * Tabla contacto
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

@Data
@Entity
@Table(name = "contact")

public class contactD implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador del contacto
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;
    /**
     * Nombre del contacto
     */
    @Column(name = "contact_name")
    private String name;
    /**
     * Email del contacto
     */
    @Column(name = "contact_email")
    private String email;

    @Column(name = "contact_number")
    private BigInteger number;
    /**
     * Fecha de cumpleaños del contacto
     */
    @Column(name = "contact_date")
    private Date date;
    /**
     * Relacion entre el contacto y el telefono (Un telefono puede tener muchos contactos)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = phoneD.class, optional = false)
    @JoinColumn(name = "phone_id")
    @JsonBackReference
    private phoneD phone;

}
