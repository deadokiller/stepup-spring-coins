package ru.vtb.javapro.homework.repository.impl;

import org.springframework.stereotype.Component;
import ru.vtb.javapro.homework.model.UserProductResponse;
import ru.vtb.javapro.homework.repository.UserProductDao;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserProductDaoImpl implements UserProductDao {
    private final DataSource dataSource;

    public UserProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<UserProductResponse> readByProductId(int productId) {
        List<UserProductResponse> userList = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var resultSet = st.executeQuery(
                    "select p.product, p.product_type, u.name, up.account_number, up.balance " +
                            "from user_product up " +
                            "inner join product p on p.id = up.product_id " +
                            "inner join \"user\" u on u.id = up.user_id   where product_id = %s".formatted(productId));

            while (resultSet.next()) {
                userList.add(new UserProductResponse(resultSet.getString("product")
                        , resultSet.getString("product_type")
                        , resultSet.getString("name")
                        , resultSet.getString("account_number")
                        , resultSet.getFloat("balance")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<UserProductResponse> readByUserId(int userId) {
        List<UserProductResponse> userList = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var st = connection.createStatement();) {
            var resultSet = st.executeQuery(
                    "select p.product, p.product_type, u.name, up.account_number, up.balance " +
                            "from user_product up " +
                            "inner join product p on p.id = up.product_id " +
                            "inner join \"user\" u on u.id = up.user_id   where user_id = %s"
                                    .formatted(userId));

            while (resultSet.next()) {
                userList.add(new UserProductResponse(resultSet.getString("product")
                        , resultSet.getString("product_type")
                        , resultSet.getString("name")
                        , resultSet.getString("account_number")
                        , resultSet.getFloat("balance")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
}
