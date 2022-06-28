package com.taller8.tallersql2.services;

import java.util.List;
import java.util.Optional;

import com.taller8.tallersql2.domain.contactD;
import com.taller8.tallersql2.domain.phoneD;

public interface IUserService {

    public List<contactD> list();

    public List<phoneD> listPhone();

    public contactD save(contactD user);

    public phoneD savePhone(phoneD phone);

    public contactD update(Long id, contactD user);

    public phoneD updatePhone(Long id, phoneD phone);

    public void delete(contactD user);

    public void deletePhone(phoneD phone);

    public Optional<contactD> findUser(contactD user);

    public Optional<phoneD> findPhone(phoneD phone);
}
