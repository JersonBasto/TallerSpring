package com.taller8.tallersql2.dao;

import org.springframework.data.repository.CrudRepository;

import com.taller8.tallersql2.domain.phoneD;
/**
 * Se coloca la clase con la tabla que se va a manejar
 * 
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

public interface phoneDao extends CrudRepository<phoneD, Long> {
}
