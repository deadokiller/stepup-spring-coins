package ru.vtb.javapro.homework.repository.impl;

import org.springframework.stereotype.Component;
import ru.vtb.javapro.homework.repository.UserDao;
import ru.vtb.javapro.homework.model.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private final DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(User user) {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            st.execute("insert into users(id,name) select %s,'%s'".formatted(user.getId(), user.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> read() {
        List<User> userList = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var resultSet = st.executeQuery("select id, name from users");

            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong("id"), resultSet.getString("name")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public void update(Long id, String name) {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            st.execute(("update users " +
                    "set name = '%s' " +
                    "where id = %s").formatted(name, id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var command = "delete from users " +
                    "where id = %s".formatted(id);
            st.execute(command);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var command = "delete from users ";
            st.execute(command);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
