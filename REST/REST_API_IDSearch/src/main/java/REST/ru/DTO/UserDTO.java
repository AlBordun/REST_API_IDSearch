package REST.ru.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonProperty(value = "user_id")
    private long Id;

    private String username;

    private String name;

    private String lastName;

    @JsonIgnore
    private String password;

    private String email;

    private int age;

    public boolean isNull() {
        return this.name == null || this.lastName == null || this.email == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, lastName, email, password);
    }
}
