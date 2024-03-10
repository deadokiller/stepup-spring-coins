package ru.stepup.spring.coins.core.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;
import ru.stepup.spring.coins.core.api.ProductResponse;

public class ProductIntegrationRestClient implements ProductIntegration {
    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(ProductIntegrationRestClient.class.getName());

    public ProductIntegrationRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public ProductResponse getUserProduct(Integer userId) {
        var response = restClient.get()
                .uri("/user?userId=%s".formatted(userId))
                .header("USERID", "12345678")
                .header("Accept", "application/json")
                .retrieve()
                .body(ProductResponse.class);
        logger.info("response: {}", response);
        return response;
    }
}
