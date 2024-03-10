package ru.stepup.spring.coins.core.api;

import java.util.List;

public class ProductResponse {
    private List<UserProductResponse> userProductResponseList;

    public ProductResponse(List<UserProductResponse> userProductResponseList) {
        this.userProductResponseList = userProductResponseList;
    }

    public List<UserProductResponse> getProductList() {
        return userProductResponseList;
    }

    public void setProductList(List<UserProductResponse> userProductResponseList) {
        this.userProductResponseList = userProductResponseList;
    }

    private ProductResponse() {

    }
}