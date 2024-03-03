package ru.vtb.javapro.homework.model;

public class UserProduct {
    private long id;
    private String accountNumber;
    private float balance;
    private String productType;

    public UserProduct(long id, String accountNumber, float balance, String productType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public String getProductType() {
        return productType;
    }
}
