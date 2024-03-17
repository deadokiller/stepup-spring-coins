package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.api.UserProductResponse;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductIntegration productIntegration;

    public ProductService(ProductIntegration productIntegration) {
        this.productIntegration = productIntegration;
    }

    public Optional<UserProductResponse> getUserProduct(Integer userId, String productId) {
        var productList = productIntegration.getUserProduct(userId);
        return productList.getProductList()
                .stream()
                .filter(p -> p.getProductId().equals(Long.parseLong(productId)))
                .findFirst();
    }
    public ProductResponse getUserProducts(Integer userId) {
       return productIntegration.getUserProduct(userId);
    }
}
