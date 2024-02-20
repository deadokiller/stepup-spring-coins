package ru.vtb.javapro.lesson8.service;

import org.springframework.stereotype.Service;
import ru.vtb.javapro.lesson8.model.User;
import ru.vtb.javapro.lesson8.repository.UserDao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(User user) {
        userDao.create(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public User getUser(Long id) {
        return userDao.read()
                .stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return userDao.read();
    }

    public void update(Long id, String name) {
        userDao.update(id, name);
    }

    public void deleteAll() {
        var t = userDao.read()
                .stream()
                .peek(user -> userDao.delete(user.getId()))
                .toList();
    }
}
