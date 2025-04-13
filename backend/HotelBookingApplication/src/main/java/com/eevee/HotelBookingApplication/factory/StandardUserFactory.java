package com.eevee.HotelBookingApplication.factory;

import com.eevee.HotelBookingApplication.model.Role;
import com.eevee.HotelBookingApplication.model.User;
import com.eevee.HotelBookingApplication.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandardUserFactory implements UserFactory {

    private final PasswordEncoder encoder;
    private final RoleRepository roleRepo;

    public StandardUserFactory(PasswordEncoder encoder, RoleRepository roleRepo) {
        this.encoder = encoder;
        this.roleRepo = roleRepo;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepo.findByName("ROLE_USER").orElseThrow();
        user.setRoles(List.of(role));
        return user;
    }
}
