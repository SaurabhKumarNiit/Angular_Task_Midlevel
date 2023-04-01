package backendTask.Product.controller;

import backendTask.Product.domain.Product;
import backendTask.Product.exception.ProductAlreadyExistException;
import backendTask.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

    ResponseEntity responseEntity ;
    @Autowired
    ProductService productService;

    //  http://localhost:8084/product/addProduct
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProducts(@RequestBody Product product) throws ProductAlreadyExistException {
        Product productAdded = productService.addProduct(product);

        return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
    }

    //  http://localhost:8084/product/getAllProducts
    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }


    // http://localhost:8084/product/productName
    @GetMapping("/{productName}")
    public ResponseEntity<?> getProductByProductName(@PathVariable String productName ) {
        Product product = productService.getProductByProductName(productName);
        responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
        return responseEntity;
    }

}
