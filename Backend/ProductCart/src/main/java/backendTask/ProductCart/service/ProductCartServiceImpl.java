package backendTask.ProductCart.service;

import backendTask.ProductCart.domain.ProductCart;
import backendTask.ProductCart.exception.ProductAlreadyExistException;
import backendTask.ProductCart.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCartServiceImpl implements ProductCartService{

    @Autowired
    ProductCartRepository productCartRepository;

    @Override
    public ProductCart addItemInCart( ProductCart cart) throws ProductAlreadyExistException {
        return productCartRepository.save(cart);
    }

    @Override
    public List<ProductCart> getCartItemByUserEmail(String email) {
        return null;
    }

    @Override
    public List<ProductCart> getAllCartProducts() {
        return productCartRepository.findAll();
    }

    @Override
    public ProductCart updateQuantity(ProductCart cart, int quantity) {


        int currentQuantity = cart.getQuantity();
        int updatedQuantity = currentQuantity + quantity;
        cart.setQuantity(updatedQuantity);

        return productCartRepository.save(cart);
    }

    @Override
    public boolean deleteCartItem(String productName) throws Exception {
        boolean result = false;
        if (productCartRepository.findById(productName).isEmpty()){
            throw new Exception();
        }else{
            productCartRepository.deleteById(productName);
            result = true;
        }
        return result;
    }
}
