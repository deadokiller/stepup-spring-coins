package ru.vtb.javapro.lesson8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vtb.javapro.lesson8.config.AppConfig;
import ru.vtb.javapro.lesson8.model.User;
import ru.vtb.javapro.lesson8.repository.UserDao;
import ru.vtb.javapro.lesson8.service.UserService;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var userDao = context.getBean("userDao", UserDao.class);
        System.out.println(userDao);
        var userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        var dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
        userService.deleteAll();
        userService.createUser(new User(11L,"test"));
        System.out.println(userService.getUser(11L));
        userService.update(11L,"test1");
        System.out.println(userService.getUser(11L));
        userService.createUser(new User(12L,"test2"));
        var list = userService.getAllUsers();
        System.out.println(list);
        userService.delete(12L);
        var list2 = userService.getAllUsers();
        System.out.println(list2);
    }
}