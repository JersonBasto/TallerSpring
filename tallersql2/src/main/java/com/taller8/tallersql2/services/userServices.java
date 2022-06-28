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

@Service
public class userServices implements IUserService {

    @Autowired // para inyectar userDao
    private contactDao contactDao;

    @Autowired
    private phoneDao phoneDao;

    @Override
    @Transactional(readOnly = true)
    public List<contactD> list() {
        return (List<contactD>) contactDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<phoneD> listPhone(){
        return (List<phoneD>) phoneDao.findAll();
    }

    @Override
    @Transactional
    public contactD save(contactD user) {
        return contactDao.save(user);
    }

    @Override
    @Transactional
    public phoneD savePhone(phoneD phone) {
        return phoneDao.save(phone);
    }

    @Override
    @Transactional
    public contactD update(Long Id, contactD user) {
        user.setId(Id);
        return contactDao.save(user);
    }

    @Override
    @Transactional
    public phoneD updatePhone(Long Id, phoneD phone) {
        phone.setPhoneId(Id);
        return phoneDao.save(phone);
    }

    @Transactional
    public void updateName(Long id, contactD user) {
        contactDao.updateName(id, user.getName());
    }

    @Transactional
    public void updateNumber(Long id, contactD user) {
        contactDao.updateNumber(id, user.getNumber());
    }

    @Transactional
    public void updateEmail(Long id, contactD user) {
        contactDao.updateEmail(id, user.getEmail());
    }

    @Transactional
    public void updateDate(Long id, contactD user) {
        contactDao.updateDate(id, user.getDate());
    }

    @Override
    @Transactional
    public void delete(contactD user) {
        contactDao.delete(user);
    }

    @Override
    @Transactional
    public void deletePhone(phoneD phone) {
        phoneDao.delete(phone);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<contactD> findUser(contactD user) {
        Optional<contactD> userf = contactDao.findById(user.getId());
        return userf;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<phoneD> findPhone(phoneD phone) {
        Optional<phoneD> userf = phoneDao.findById(phone.getPhoneId());
        return userf;
    }

}
