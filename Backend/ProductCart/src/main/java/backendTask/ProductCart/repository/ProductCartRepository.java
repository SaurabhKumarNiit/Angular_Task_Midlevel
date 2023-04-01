package backendTask.ProductCart.repository;

import backendTask.ProductCart.domain.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart,String> {

//    public ProductCart findProductCartByEmail(String email);
}
