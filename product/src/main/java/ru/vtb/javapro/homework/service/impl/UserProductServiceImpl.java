package ru.vtb.javapro.homework.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.vtb.javapro.homework.mapping.UserProductResponseMapper;
import ru.vtb.javapro.homework.model.ProductResponse;
import ru.vtb.javapro.homework.repository.UserProductRepository;
import ru.vtb.javapro.homework.service.UserProductService;

@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductRepository userProductRepository;
    private final UserProductResponseMapper userProductResponseMapper = Mappers.getMapper(UserProductResponseMapper.class);

    public UserProductServiceImpl(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    @Override
    public ProductResponse getProductsById(int userId, int productId) {
        var view = userProductRepository.readByProductId(userId, productId);
        return new ProductResponse(userProductResponseMapper.mapUserProductResponse(view));
    }

    @Override
    public ProductResponse getUserById(int userId) {
        var view = userProductRepository.readByUserId(userId);
        return new ProductResponse(userProductResponseMapper.mapUserProductResponse(view));
    }
}
