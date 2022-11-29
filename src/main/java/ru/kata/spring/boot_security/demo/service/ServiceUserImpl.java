package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.DaoUser;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
public class ServiceUserImpl implements ServiceUser {

    private DaoUser daoUser;

    @Autowired
    public ServiceUserImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Transactional
    public List<User> getAllUser() {
        return daoUser.getAllUser();
    }

    @Transactional
    public User getUserById(int id) {
        return daoUser.getUserById(id);
    }

    @Transactional
    public void saveUser(User user) {
        daoUser.saveUser(user);
    }

    @Transactional
    public void removeUserById(int id) {
        daoUser.removeUserById(id);
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return daoUser.getUserByUserName(userName);
    }
}
