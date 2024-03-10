package ru.vtb.javapro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.entity.User;
import ru.vtb.javapro.homework.repository.UserDao;
import ru.vtb.javapro.homework.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

/*    @Override
    public User getUser(Long id) {
        return userDao.read()
                .stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);
    }
*/
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void update(Long id, String name) {

        userDao.save(new User(id,name));
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
