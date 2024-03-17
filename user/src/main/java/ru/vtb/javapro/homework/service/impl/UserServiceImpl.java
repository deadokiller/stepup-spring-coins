package ru.vtb.javapro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.entity.User;
import ru.vtb.javapro.homework.repository.UserRepository;
import ru.vtb.javapro.homework.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

/*    @Override
    public User getUser(Long id) {
        return userRepository.read()
                .stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);
    }
*/
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void update(Long id, String name) {

        userRepository.save(new User(id,name));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
