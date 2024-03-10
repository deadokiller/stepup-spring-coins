package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;

@Service
public class ProductService {

    private final ProductIntegration productIntegration;

    public ProductService(ProductIntegration productIntegration) {
        this.productIntegration = productIntegration;
    }

    public ProductResponse getUserProduct(Integer userId) {
        return productIntegration.getUserProduct(userId);
    }
}
