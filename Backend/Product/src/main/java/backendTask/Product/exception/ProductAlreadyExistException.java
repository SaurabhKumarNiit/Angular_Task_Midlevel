package backendTask.Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Product Already Exits")
public class ProductAlreadyExistException extends Exception{
}
