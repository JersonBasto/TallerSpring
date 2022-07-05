package com.taller8.tallersql2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller8.tallersql2.dao.contactDao;
import com.taller8.tallersql2.dao.phoneDao;
import com.taller8.tallersql2.domain.contactD;
import com.taller8.tallersql2.domain.phoneD;

/**
 * Clase extendida de IUserService para el manejo del telefono y los contactos
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

@Service
public class userServices implements IUserService {

    /**
     * Se inyecta el repositorio del contacto
     */
    @Autowired 
    private contactDao contactDao;
    /**
     * Se inyectan el repositorio de telefono
     */
    @Autowired
    private phoneDao phoneDao;

    /**
     * Devuelve una lista de contactos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @Override
    @Transactional(readOnly = true)
    public List<contactD> list() {
        return (List<contactD>) contactDao.findAll();
    }
    /**
     * Devuelve una lista de telefonos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional(readOnly = true)
    public List<phoneD> listPhone() {
        return (List<phoneD>) phoneDao.findAll();
    }
    /**
     * Guarda el contacto en la base de datos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional
    public contactD save(contactD user) {
        return contactDao.save(user);
    }
    /**
     * Guarda el telefono en la base de datos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional
    public phoneD savePhone(phoneD phone) {
        return phoneDao.save(phone);
    }
    /**
     * Se actualiza datos del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional
    public contactD update(Long id, contactD user) {
        user.setId(id);
        return contactDao.save(user);
    }
    /**
     * Se actualiza datos del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional
    public phoneD updatePhone(Long id, phoneD phone) {
        phone.setPhoneId(id);
        return phoneDao.save(phone);
    }
    /**
     * Actualiza el nombre del Contacto
     * @param id Recibe id del contacto
     * @param user Recive el nombre a actualizar
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Transactional
    public void updateName(Long id, contactD user) {
        contactDao.updateName(id, user.getName());
    }
    /**
     * Actualiza el numero del contacto
     * @param id Recibe el id del contacto
     * @param user Recibe el numero a actualizar
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @Transactional
    public void updateNumber(Long id, contactD user) {
        contactDao.updateNumber(id, user.getNumber());
    }

    /**
     * Actualiza el email del contacto
     * @param id Recibe el id del contacto
     * @param user Recibe el email a actualizar
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @Transactional
    public void updateEmail(Long id, contactD user) {
        contactDao.updateEmail(id, user.getEmail());
    }
    /**
     * Actualiza la fecha de cumpleaños del contacto
     * @param id Recibe el id del contacto
     * @param user Recibe la fecha de cumpleaños a actualizar
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Transactional
    public void updateDate(Long id, contactD user) {
        contactDao.updateDate(id, user.getDate());
    }
    /**
     * Borra el contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional
    public void delete(contactD user) {
        contactDao.delete(user);
    }
    /**
     * Borra el telefono
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    @Override
    @Transactional
    public void deletePhone(phoneD phone) {
        phoneDao.delete(phone);
    }
    /**
     * Borra todos los contactos del telefono
     * @param id Recibe el id del telefono 
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Transactional
    public void delAllContacts(Long id) {
        contactDao.delAllContacts(id);
    }
    /**
     * Encentra el contacto por el id
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional(readOnly = true)
    public Optional<contactD> findUser(Long id, contactD user) {
        Optional<contactD> userf = contactDao.findById(id);
        return userf;
    }
    /**
     * Encuentra el telefono por el id
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    @Override
    @Transactional(readOnly = true)
    public Optional<phoneD> findPhone(Long id, phoneD phone) {
        phone.setPhoneId(id);
        Optional<phoneD> userf = phoneDao.findById(phone.getPhoneId());
        return userf;
    }

}
