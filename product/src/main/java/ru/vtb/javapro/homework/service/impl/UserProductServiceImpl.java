package ru.vtb.javapro.homework.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.model.ProductResponse;
import ru.vtb.javapro.homework.repository.UserProductDao;
import ru.vtb.javapro.homework.repository.impl.UserProductDaoImpl;
import ru.vtb.javapro.homework.service.UserProductService;

@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductDao userProductDao;

    public UserProductServiceImpl(UserProductDao userProductDao) {
        this.userProductDao = userProductDao;
    }

    @Override
    public ProductResponse getProductsById(int productId) {
        return new ProductResponse(userProductDao.readByProductId(productId));
    }

    @Override
    public ProductResponse getUserById(int userId) {
        return new ProductResponse(userProductDao.readByUserId(userId));
    }
}
