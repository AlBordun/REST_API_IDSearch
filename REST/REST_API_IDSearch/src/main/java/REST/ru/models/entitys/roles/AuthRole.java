package REST.ru.models.entitys.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auth_roles")
@Data
@NoArgsConstructor
public class AuthRole {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role name;

    public AuthRole(Role name) {
        this.name = name;
    }
}
