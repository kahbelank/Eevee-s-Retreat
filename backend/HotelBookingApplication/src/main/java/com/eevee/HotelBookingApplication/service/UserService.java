package com.eevee.HotelBookingApplication.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eevee.HotelBookingApplication.exception.UserAlreadyExistsException;
import com.eevee.HotelBookingApplication.model.Role;
import com.eevee.HotelBookingApplication.model.User;
import com.eevee.HotelBookingApplication.repository.RoleRepository;
import com.eevee.HotelBookingApplication.repository.UserRepository;
import com.eevee.HotelBookingApplication.factory.UserFactory;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserFactory userFactory;

    // @Override
    // public User registerUser(User user) {
    //     if (userRepository.existsByEmail(user.getEmail())) {
    //         throw new UserAlreadyExistsException(user.getEmail() + " already exists");
    //     }
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     System.out.println(user.getPassword());
    //     Role userRole = roleRepository.findByName("ROLE_USER")
    //             .orElseThrow(() -> new RuntimeException("Error: ROLE_USER not found in the database"));
    //     user.setRoles(Collections.singletonList(userRole));
    //     return userRepository.save(user);
    // }

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException(user.getEmail() + " already exists");
        }
        User createdUser = userFactory.createUser(user); // delegate creation
        return userRepository.save(createdUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    

    @Transactional
    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if (theUser != null) {
            userRepository.deleteByEmail(email);
        }

    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
