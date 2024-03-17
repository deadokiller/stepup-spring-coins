package ru.vtb.javapro.homework.service;


import ru.vtb.javapro.homework.entity.User;

import java.util.List;

public interface UserService {
    void deleteAll();

    void update(Long id, String name);

    List<User> getAllUsers();

  //  User getUser(Long id);

    void delete(Long id);

    void createUser(User user);
}
