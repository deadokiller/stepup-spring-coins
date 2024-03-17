package ru.vtb.javapro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vtb.javapro.homework.entity.UserProduct;
import ru.vtb.javapro.homework.model.UserProductResponseView;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    @Query(value = "select p.id as productId, p.product, p.product_type as productType, u.name, up.account_number as accountNumber, up.balance " +
            "from user_product up " +
            "inner join product p on p.id = up.product_id " +
            "inner join \"user\" u on u.id = up.user_id   " +
            "where product_id = :productId" +
            "and up.user_id = :userId", nativeQuery = true)
    List<UserProductResponseView> readByProductId(int userId, int productId);
    @Query(value = "select p.id as productId,p.product, p.product_type as productType, u.name, up.account_number as accountNumber, up.balance " +
        "from user_product up " +
        "inner join product p on p.id = up.product_id " +
        "inner join \"user\" u on u.id = up.user_id   where user_id = :userId",nativeQuery = true)
    List<UserProductResponseView> readByUserId(int userId);

}
