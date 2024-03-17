package ru.vtb.javapro.homework.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.javapro.homework.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
