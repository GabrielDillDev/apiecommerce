package apiecommerce.apiecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
  
    private String email;
    private String password;
}
