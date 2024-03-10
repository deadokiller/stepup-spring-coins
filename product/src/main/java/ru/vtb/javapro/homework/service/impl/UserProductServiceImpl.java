package ru.vtb.javapro.homework.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.mapping.UserProductResponseMapper;
import ru.vtb.javapro.homework.model.ProductResponse;
import ru.vtb.javapro.homework.repository.UserProductDao;
import ru.vtb.javapro.homework.service.UserProductService;

@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductDao userProductDao;
    private final UserProductResponseMapper userProductResponseMapper = Mappers.getMapper(UserProductResponseMapper.class);

    public UserProductServiceImpl(UserProductDao userProductDao) {
        this.userProductDao = userProductDao;
    }

    @Override
    public ProductResponse getProductsById(int productId) {
        var view = userProductDao.readByProductId(productId);
        return new ProductResponse(userProductResponseMapper.mapUserProductResponse(view));
    }

    @Override
    public ProductResponse getUserById(int userId) {
        var view = userProductDao.readByUserId(userId);
        return new ProductResponse(userProductResponseMapper.mapUserProductResponse(view));
    }
}
