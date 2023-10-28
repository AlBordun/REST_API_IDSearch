package REST.ru.DTO;

import REST.ru.models.entitys.roles.AuthRole;
import REST.ru.models.entitys.roles.AuthRoleRepository;
import REST.ru.models.entitys.roles.RoleEnum;
import REST.ru.models.entitys.users.User;
import REST.ru.models.entitys.users.UserDetailsImpl;
import REST.ru.models.entitys.users.UserRepository;
import REST.ru.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Data
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserServiceImpl userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    AuthRoleRepository authRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
        userService.createAdminUser();
        System.out.println("Администратор создан");
    }

    @Transactional
    private void initializeRoles() {
        AuthRole userRole = authRoleRepository.findByName(RoleEnum.ROLE_USER)
                .orElseGet(() -> authRoleRepository.save(new AuthRole(RoleEnum.ROLE_USER)));

        AuthRole adminRole = authRoleRepository.findByName(RoleEnum.ROLE_ADMIN)
                .orElseGet(() -> authRoleRepository.save(new AuthRole(RoleEnum.ROLE_ADMIN)));

        System.out.println("Roles initialized: USER, ADMIN");
    }
}
