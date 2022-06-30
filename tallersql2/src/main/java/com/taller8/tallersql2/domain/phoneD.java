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
/**
 * Tabla de telefono
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */
@Data
@Entity
@Table(name = "phone")
public class phoneD implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador del telefono
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;
    /**
     * Operador del telefeno
     */
    @Column(name = "phone_operator")
    private String operator;
    /**
     * Numero del telefono
     */
    @Column(name = "phone_number")
    private BigInteger number;
    /**
     * Nombre del dueño del telefono
     */
    @Column(name = "phone_owner")
    private String owner;
    /**
     * Relacion entre la tabla telefono y el contacto (Un telefono puede tener muchos contactos)
     */
    @OneToMany(fetch = FetchType.EAGER, targetEntity = contactD.class, mappedBy = "phone",cascade = CascadeType.ALL)
    private List<contactD> contacts = new ArrayList<>();
}
