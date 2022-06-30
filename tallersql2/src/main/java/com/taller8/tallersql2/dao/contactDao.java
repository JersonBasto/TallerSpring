package com.taller8.tallersql2.dao;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.taller8.tallersql2.domain.contactD;

//Se coloca la clase con la tabla que se va a manejar

/**
 * Se coloca la clase con la tabla que se va a manejar
 * 
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

public interface contactDao extends CrudRepository<contactD, Long> {
        /**
         * Se crea Query para actualizar nombre
         * 
         * @param id   se obtiene ID del contacto
         * @param name Se obtiene el nombre del contacto a usar
         * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
         */
        @Modifying
        @Query("update contactD contact set contact.name = :name where contact.id = :id")
        public void updateName(
                        @Param(value = "id") Long id,
                        @Param(value = "name") String name);

        /**
         * Se crea Query para actualizar numero
         * 
         * @param id     se obtiene ID del contacto
         * @param number Se obtiene el numero del contacto a usar
         * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
         */
        @Modifying
        @Query("update contactD contact set contact.number = :number where contact.id = :id")
        public void updateNumber(
                        @Param(value = "id") Long id,
                        @Param(value = "number") BigInteger number);

        /**
         * Se crea Query para actualizar Email
         * 
         * @param id    se obtiene ID del contacto
         * @param email Se obtiene el Email del contacto a usar
         * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
         */
        @Modifying
        @Query("update contactD contact set contact.email = :email where contact.id = :id")
        public void updateEmail(
                        @Param(value = "id") Long id,
                        @Param(value = "email") String email);

        /**
         * Se crea Query para actualizar la fecha de cumpleaños
         * 
         * @param id    se obtiene ID del contacto
         * @param date Se obtiene la fecha de cumpleaños del contacto a usar
         * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
         */
        @Modifying
        @Query("update contactD contact set contact.date = :date where contact.id = :id")
        public void updateDate(
                        @Param(value = "id") Long id,
                        @Param(value = "date") Date date);
        /**
         * Se crea Query para borrar los contactos que contiene un telefono
         * 
         * @param id    se obtiene ID del telefono al cual sus contactos seran eliminados.
         * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
         */
        @Modifying
        @Query("delete contactD contact where contact.phone.phoneId= :id")
        public void delAllContacts(@Param(value = "id") Long id);
}
