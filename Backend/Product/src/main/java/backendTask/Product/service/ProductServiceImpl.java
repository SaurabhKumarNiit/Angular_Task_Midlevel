package backendTask.Product.service;

import backendTask.Product.domain.Product;
import backendTask.Product.exception.ProductAlreadyExistException;
import backendTask.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistException {
//        if(productRepository.findByProductName(product.getProductName()).equals(product.getProductName()))
//        {
//            throw new ProductAlreadyExistException();
//        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
}
