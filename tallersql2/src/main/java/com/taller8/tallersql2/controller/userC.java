package com.taller8.tallersql2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller8.tallersql2.domain.contactD;
import com.taller8.tallersql2.services.userServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class userC {

    @Autowired
    private userServices userServices;

    @GetMapping(path = "/users")
    public List<contactD> list() {
        var users = userServices.list();
        return users;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<contactD> create(contactD user) {
        log.info("Datos de usuario: {}", user);
        userServices.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<contactD> delete(contactD user) {
        log.info("Usuario a borrar: {}", user);
        userServices.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<contactD> update(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping(path = "/users/userName/{id}")
    public ResponseEntity<contactD> updateName(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateName(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping(path = "/users/userNumber/{id}")
    public ResponseEntity<contactD> updateUserNumber(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateNumber(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping(path = "/users/userEmail/{id}")
    public ResponseEntity<contactD> updateUserEmail(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateEmail(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping(path = "/users/userDate/{id}")
    public ResponseEntity<contactD> updateUserDate(contactD user, @PathVariable("id") Long id) {
        log.info("El usuario a actualizar es: {}", user);
        userServices.updateDate(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping(path = "/users/userDateOfBirth/{id}")
    public void updateUserDateOfBirth(contactD user, @PathVariable("id") Long id) {

    }

}
