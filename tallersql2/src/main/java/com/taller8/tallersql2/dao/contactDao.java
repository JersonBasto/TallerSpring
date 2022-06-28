package com.taller8.tallersql2.dao;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.taller8.tallersql2.domain.contactD;

//Se coloca la clase con la tabla que se va a manejar

public interface contactDao extends CrudRepository<contactD, Long> {

        @Modifying
        @Query("update contactD contact set contact.Name = :Name where contact.id = :id")
        public void updateName(
                        @Param(value = "id") Long id,
                        @Param(value = "Name") String Name);

        @Modifying
        @Query("update contactD contact set contact.Number = :Number where contact.id = :id")
        public void updateNumber(
                        @Param(value = "id") Long id,
                        @Param(value = "Number") BigInteger Number);

        @Modifying
        @Query("update contactD contact set contact.Email = :Email where contact.id = :id")
        public void updateEmail(
                        @Param(value = "id") Long id,
                        @Param(value = "Email") String Email);

        @Modifying
        @Query("update contactD contact set contact.Date = :Date where contact.id = :id")
        public void updateDate(
                        @Param(value = "id") Long id,
                        @Param(value = "Date") Date Date);
}
