package ru.vtb.javapro.homework.service;

import ru.vtb.javapro.homework.model.ProductResponse;

public interface UserProductService {
    ProductResponse getProductsById(int productId);

    ProductResponse getUserById(int userId);
}
