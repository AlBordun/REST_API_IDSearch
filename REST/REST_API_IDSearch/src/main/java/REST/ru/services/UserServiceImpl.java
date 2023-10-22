package REST.ru.services;

import REST.ru.models.entitys.users.User;
import REST.ru.models.entitys.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl {

    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;


//    public UserServiceImpl(@Autowired PasswordEncoder passwordEncoder,
//                           @Autowired UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//
//    }

    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow(()
                -> new NoSuchElementException("USER with id='" + userId + "' does not exist"));
    }

    public User edit(long id, User newUser) {
        User oldUser = userRepository.getOne(id);
        if (newUser.getEmail() != null) oldUser.setEmail(newUser.getEmail());
        if (newUser.getUsername() != null) oldUser.setUsername(newUser.getUsername());
        if (newUser.getPassword() != null) oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(oldUser);
    }

    public void delete(long id) {

    }


    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<User> getUsersSearchByUsername(String username, Pageable pageable) {
        return userRepository.findAllByUsernameLike("%" + username + "%", pageable);
    }

    public User findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(()
                -> new NoSuchElementException("USER with id='" + userId + "' does not exist"));
    }
}
