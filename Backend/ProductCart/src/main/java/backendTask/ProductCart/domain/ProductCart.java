package backendTask.ProductCart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCart {


    @Id
    private String productName;
    private String productPrice;
    private int quantity=1;

    public ProductCart(String productName, String productPrice,int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public ProductCart() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}
