package ru.stepup.spring.coins.core.api;

import java.math.BigDecimal;

public class UserProductResponse {
    private String product;

    private Long productId;
    private String productType;
    private String name;
    private String accountNumber;

    private BigDecimal balance;

    public UserProductResponse(Long productId,String product, String productType, String name, String accountNumber, BigDecimal balance) {
        this.product = product;
        this.productType = productType;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
