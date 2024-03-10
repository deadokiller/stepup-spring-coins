package ru.stepup.spring.coins.core.integrations;

import ru.stepup.spring.coins.core.api.ProductResponse;


public interface ProductIntegration {
    ProductResponse getUserProduct(Integer userId);
}
