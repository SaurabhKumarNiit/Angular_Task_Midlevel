package backendTask.Product.service;

import backendTask.Product.domain.Product;
import backendTask.Product.exception.ProductAlreadyExistException;

import java.util.List;

public interface ProductService {

    Product addProduct(Product item) throws ProductAlreadyExistException;
    List<Product> getAllProduct();

    public Product getProductByProductName(String productName) ;
}
