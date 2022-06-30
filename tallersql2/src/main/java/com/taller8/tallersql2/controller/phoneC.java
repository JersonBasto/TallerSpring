package com.taller8.tallersql2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.taller8.tallersql2.domain.phoneD;
import com.taller8.tallersql2.services.userServices;

import lombok.extern.slf4j.Slf4j;
/**
 * Controlador para telefono
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 * 
 */

@Slf4j
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class phoneC {
    /**
     * Se inserta los servicios
     */
    @Autowired
    private userServices userServices;

    /**
     * Se obtiene una lista de todos los telefonos creados hasta el momento
     * 
     * @return Una lista con objetos de la clase phoneD
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @GetMapping(path = "/phones")
    public List<phoneD> list() {
        var phones = userServices.listPhone();
        return phones;
    }
    /**
     * Se crea un telefono en la base de datos
     * 
     * @param phone Se recibe los datos del telefono a crear
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido de phone
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PostMapping(path = "/phone")
    public ResponseEntity<phoneD> createPhone(@RequestBody phoneD phone) {
        log.info("Datos de usuario: {}", phone);
        userServices.savePhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

    /**
     * Borrar un telefono de la base datos
     * 
     * @param phone Recibe el id del telefono a borrar de la base de datos
     * @return  Devuelve una respuesta HTTP de 201 junto a un json con el contenido de phone
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @DeleteMapping(path = "/phone/{phoneId}")
    public ResponseEntity<phoneD> delete(phoneD phone) {
        log.info("Usuario a borrar: {}", phone);
        userServices.deletePhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }
    /**
     * Actualizar al informacion de un telefono en la base de datos
     * 
     * @param phone Recibe los datos a actualizar
     * @param id Recibe el ID del telefono a actualizar
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido de phone
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PutMapping(path = "/phone/{id}")
    public ResponseEntity<phoneD> update(@RequestBody phoneD phone, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", phone);
        userServices.updatePhone(id, phone);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

}