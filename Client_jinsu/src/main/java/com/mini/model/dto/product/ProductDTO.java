package com.mini.model.dto.product;

public class ProductDTO {
    private String productName;
    private int productQuantity;
    private int productPrice;

    @Override
    public String toString() {
        return "ProductDTO[" +
                "productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                ']';
    }
}
