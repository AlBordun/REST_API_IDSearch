package REST.ru.models.entitys.roles;

import REST.ru.models.entitys.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Entity(name = "Role")
@Table(name = "roles")
@NoArgsConstructor
@Data
public class Role  {
//
//    ROLE_USER,
//    ROLE_ADMIN;
//
//    @Override
//    public String getAuthority() {
//        return name();
//    }

    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "professionals_roles",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final Set<User> professionals = new HashSet<>();

    @JsonProperty(value = "role_id")
    @Id
    @SequenceGenerator(
            name = "role_id",
            sequenceName = "role_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_id"
    )
    @Column(name = "role_id")
    private long roleId;

    @JsonProperty(value = "role_name")
    @Column(name = "role_name", nullable = false)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

}
