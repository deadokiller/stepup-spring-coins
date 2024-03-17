package ru.stepup.spring.coins.core.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductResponse getUserProduct(@RequestHeader("USERID") Integer userId) {
        return productService.getUserProducts(userId);
    }
}
