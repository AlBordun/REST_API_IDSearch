package REST.ru.DTO;


import lombok.Data;


import java.util.Set;

@Data
public class SignupRequest {

    private String email;
    private String username;
    private String password;
    private Set<String> roles;

}
