package com.taller8.tallersql2.services;

import java.util.List;
import java.util.Optional;

import com.taller8.tallersql2.domain.contactD;
import com.taller8.tallersql2.domain.phoneD;
/**
 * Interface para el servicio de Telefono y Contactos
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

public interface IUserService {

    /**
     * Devuelve una lista de contactos
     * 
     * @return Una lista de contactos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public List<contactD> list();

    /**
     * Devuelve una lista de Telefonos
     * 
     * @return Una lista de Telefonos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public List<phoneD> listPhone();

    /**
     * Crea un contacto
     * 
     * @param user Recibe los datos del contacto
     * @return El usuario creado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public contactD save(contactD user);

    /**
     * Crea un telefono
     * 
     * @param phone Recibe los datos del telefono
     * @return el telefono creado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public phoneD savePhone(phoneD phone);

    /**
     * Actualiza los datos del contacto
     * 
     * @param id Recibe el id del contacto
     * @param user  recibe datos del contacto
     * @return  el contacto con los nuevos datos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public contactD update(Long id, contactD user);

    /**
     * Actualiza datos del telefono
     * 
     * @param id recibe el id del telefono
     * @param phone recibe los datos del telefono
     * @return El telefono con los datos nuevos
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    public phoneD updatePhone(Long id, phoneD phone);

    /**
     * Recibe el id del contacto a borrar
     * 
     * @param user recibe el id del contacto
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */
    public void delete(contactD user);

    /**
     * Recibe el id del telefono a borrar
     * 
     * @param phone recibe el id del contacto a crear
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public void deletePhone(phoneD phone);
    /**
     * Busca contacto por id
     * 
     * @param id  recibe el id del contacto
     * @param user reicibe id del contacto
     * @return El contacto encontrado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public Optional<contactD> findUser(Long id, contactD user);

    /**
     * Busca telefono por id
     * 
     * @param id recibe el id del telefono
     * @param phone recibe el id del telefono
     * @return El telefono encontrado
     * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
     */

    public Optional<phoneD> findPhone(Long id, phoneD phone);
}
