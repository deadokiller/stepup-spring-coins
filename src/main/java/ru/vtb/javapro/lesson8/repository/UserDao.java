package ru.vtb.javapro.lesson8.repository;

import org.springframework.stereotype.Component;
import ru.vtb.javapro.lesson8.model.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(User user) {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            st.execute("insert into users(id,username) select %s,'%s'".formatted(user.getId(), user.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<User> read() {
        List<User> userList = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var resultSet = st.executeQuery("select id, username from users");

            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong("id"), resultSet.getString("username")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public void update(Long id, String name) {
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            st.execute(("update users " +
                    "set username = '%s' " +
                    "where id = %s").formatted(name, id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

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
}
