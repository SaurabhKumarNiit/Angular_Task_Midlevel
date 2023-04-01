package backendTask.ProductCart.service;

import backendTask.ProductCart.domain.ProductCart;
import backendTask.ProductCart.exception.ProductAlreadyExistException;

import java.util.List;

public interface ProductCartService {

    ProductCart addItemInCart( ProductCart cart) throws ProductAlreadyExistException;

    List<ProductCart> getCartItemByUserEmail(String email);

    List<ProductCart> getAllCartProducts();

    ProductCart updateQuantity( ProductCart cart,int quantity);

    boolean deleteCartItem(String productName) throws Exception;
}
