package climbingApplication.DTO.Product;

public class ProductDTO {
    private String productName;
    private int productQuantity;
    private int productPrice;

    public ProductDTO() {
    }

    public ProductDTO(String productName, int productQuantity, int productPrice) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                '}';
    }
}
