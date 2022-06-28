package com.taller8.tallersql2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taller8.tallersql2.domain.phoneD;
import com.taller8.tallersql2.services.userServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class phoneC {

    @Autowired
    private userServices userServices;

    @GetMapping(path = "/phones")
    public List<phoneD> list() {
        var phones = userServices.listPhone();
        return phones;
    }

    @PostMapping(path = "/phone")
    public ResponseEntity<phoneD> create(phoneD phone) {
        log.info("Datos de usuario: {}", phone);
        userServices.savePhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/phone/{id}")
    public ResponseEntity<phoneD> delete(phoneD phone) {
        log.info("Usuario a borrar: {}", phone);
        userServices.deletePhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @PutMapping(path = "/phone/{id}")
    public ResponseEntity<phoneD> update(phoneD phone, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", phone);
        userServices.updatePhone(id, phone);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

}