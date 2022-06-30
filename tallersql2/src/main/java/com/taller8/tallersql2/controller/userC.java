package com.taller8.tallersql2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taller8.tallersql2.domain.contactD;
import com.taller8.tallersql2.domain.phoneD;
import com.taller8.tallersql2.services.userServices;

import lombok.extern.slf4j.Slf4j;

/**
 * Controlador para Contactos
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class userC {
    /**
     * Se hace uso de los servicios creados.
     */
    @Autowired
    private userServices userServices;

    /**
     * Obtiene una lista de los usuarios creados
     * 
     * @return una lista de objetos de la clase contactD
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @GetMapping(path = "/users")
    public List<contactD> list() {
        var users = userServices.list();
        return users;
    }

    /**
     * Se obtiene los datos de un solo telefono a partir del ID
     * 
     * @param phone obtiene datos del telefono
     * @param id   Obteiene el id del telefono a buscar
     * @return Devuelve los valores del telefono encontrado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @GetMapping(path = "/phoneid/{id}")
    public Optional<phoneD> phoneById(phoneD phone, @PathVariable("id") Long id) {
        var phoneId = userServices.findPhone(id, phone);
        return phoneId;
    }

    /**
     * Se obtiene los datos de un solo contacto a partir del ID
     * 
     * @param contact obtiene los datos del contacto
     * @param id  Obtiene el id del contacto
     * @return  Devuelve los valores del contacto encontrado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @GetMapping(path = "/users/{id}")
    public Optional<contactD> userById(contactD contact, @PathVariable("id") Long id) {
        var userId = userServices.findUser(id, contact);
        return userId;
    }

    /**
     * Se crear un contacto en la base de datos
     * 
     * @param user Recibe los valores del contacto a crear
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PostMapping(path = "/user")
    public ResponseEntity<contactD> create(@RequestBody contactD user) {
        System.out.println(user);
        log.info("Datos de usuario: {}", user);
        userServices.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * Se borra contacto de la base de datos
     * 
     * @param user Recibe el id del contacto a borrar.
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<contactD> delete(contactD user) {
        log.info("Usuario a borrar: {}", user);
        userServices.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    /**
     * Borra todos los contactos de un telefono a partir del ID del telefono
     * 
     * @param id Recibe el id del telefono
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @DeleteMapping(path = "/contacts/{id}")
    public void deleteAllContacts(@PathVariable("id") Long id) {
        log.info("Usuario a borrar: {}", id);
        userServices.delAllContacts(id);
    }

    /**
     * Actualiza los datos del contacto en la base de datos
     * 
     * @param user Son los datos a actualizar en la base de datos
     * @param id Recibe el ID del contacto
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */


    @PutMapping(path = "/users/{id}")
    public ResponseEntity<contactD> update(@RequestBody contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Actualiza solo el nombre del contacto
     * 
     * @param user Recibe el nombre del contacto a actualizar
     * @param id Recibe el ID del contacto a actualizar
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PatchMapping(path = "/users/userName/{id}")
    public ResponseEntity<contactD> updateName(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateName(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Actualiza solo el numero del contacto
     * 
     * @param user Recibe el numero del contacto a actualizar
     * @param id Recibe el ID del contacto a actualizar
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PatchMapping(path = "/users/userNumber/{id}")
    public ResponseEntity<contactD> updateUserNumber(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateNumber(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Actualiza solo el Email del contacto
     * 
     * @param user Recibe el Email del contacto a actualizar
     * @param id Recibe el ID del contacto a actualizar
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PatchMapping(path = "/users/userEmail/{id}")
    public ResponseEntity<contactD> updateUserEmail(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateEmail(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Actualiza solo la fecha de cumpleaños del contacto
     * 
     * @param user Recibe la fecha de cumpleaños del contacto a actualizar
     * @param id Recibe el ID del contacto a actualizar
     * @return Devuelve una respuesta HTTP de 201 junto a un json con el contenido del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @PatchMapping(path = "/users/userDate/{id}")
    public ResponseEntity<contactD> updateUserDate(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateDate(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
