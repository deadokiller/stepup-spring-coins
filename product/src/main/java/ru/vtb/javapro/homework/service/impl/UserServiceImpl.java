package ru.vtb.javapro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.repository.UserDao;
import ru.vtb.javapro.homework.service.UserService;
import ru.vtb.javapro.homework.model.User;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User getUser(Long id) {
        return userDao.read()
                .stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.read();
    }

    @Override
    public void update(Long id, String name) {
        userDao.update(id, name);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
