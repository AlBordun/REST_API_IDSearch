package REST.ru.models.entitys.users;

import REST.ru.models.entitys.roles.AuthRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.*;

import static org.hibernate.engine.transaction.internal.jta.JtaStatusHelper.isActive;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User  {
    @JsonProperty(value = "user_id")
    @Id
    @SequenceGenerator(
            name = "user_id",
            sequenceName = "user_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id"
    )
    @Column(name = "user_id")
    private long Id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "lastname", nullable = false, unique = false)
    private String lastName;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "login", nullable = false)
    private String email;

    @Transient
    private int age;

    @JsonProperty(value = "user_roles")
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AuthRole> authRole = new HashSet<>();

    public boolean isNull() {
        return this.name == null || this.lastName == null || this.email == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, lastName, email, password);
    }

}