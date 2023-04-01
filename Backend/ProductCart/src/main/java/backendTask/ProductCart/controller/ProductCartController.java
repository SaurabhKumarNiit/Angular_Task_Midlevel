package backendTask.ProductCart.controller;

import backendTask.ProductCart.domain.ProductCart;
import backendTask.ProductCart.exception.ProductAlreadyExistException;
import backendTask.ProductCart.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/cartservice")
public class ProductCartController {

    private ResponseEntity responseEntity;

    @Autowired
    private ProductCartService productCartService;

    // http://localhost:8085/cartservice/addToCart
    @PostMapping("/addToCart")
    public ResponseEntity<?> addItemsForCustomer( @RequestBody ProductCart cart) throws ProductAlreadyExistException {
        try{
            ProductCart productCart=productCartService.addItemInCart(cart);
            responseEntity=new ResponseEntity<>(productCart, HttpStatus.OK);

        }  catch (ProductAlreadyExistException e) {

            throw new ProductAlreadyExistException();
        }

        return responseEntity;
    }

    // http://localhost:8085/cartservice/cartItems
    @GetMapping("/cartItems")
    public ResponseEntity<?> getAllItems(){
            responseEntity = new ResponseEntity<>(productCartService.getAllCartProducts(),HttpStatus.OK);
        return responseEntity;
    }

    //   http://localhost:8085/cartservice/updateQuantity/{quantity}
    @PutMapping("/updateQuantity/{quantity}")
    public ResponseEntity<?> updateQuantity( @RequestBody ProductCart cart,@PathVariable("quantity") int quantity ){

        ProductCart updateQuantity = productCartService.updateQuantity( cart, quantity);

        return new ResponseEntity<>(updateQuantity,HttpStatus.OK);
    }

    //   http://localhost:8085/cartservice/delete/{productName}
    @DeleteMapping("/delete/{productName}")
    public ResponseEntity<?> deleteCartItem(@PathVariable(value = "productName") String productName) throws Exception {
        return new ResponseEntity<>(productCartService.deleteCartItem(productName),HttpStatus.OK);

    }
}
