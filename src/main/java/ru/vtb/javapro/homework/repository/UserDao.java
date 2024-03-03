package ru.vtb.javapro.homework.repository;

import ru.vtb.javapro.homework.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    List<User> read();

    void update(Long id, String name);

    void delete(Long id);

    void deleteAll();
}
