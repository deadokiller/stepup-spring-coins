package ru.vtb.javapro.homework.repository;

import ru.vtb.javapro.homework.model.UserProductResponse;

import java.util.List;

public interface UserProductDao {

    List<UserProductResponse> readByProductId(int productId);

    List<UserProductResponse> readByUserId(int userId);

}
