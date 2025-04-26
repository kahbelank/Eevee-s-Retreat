package com.eevee.HotelBookingApplication.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.eevee.HotelBookingApplication.exception.RoleAlreadyExistException;
import com.eevee.HotelBookingApplication.model.Role;
import com.eevee.HotelBookingApplication.model.User;
import com.eevee.HotelBookingApplication.repository.RoleRepository;
import com.eevee.HotelBookingApplication.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRoleSuccess() {
        Role role = new Role();
        role.setName("ADMIN"); // 👈 Only "ADMIN", not "ROLE_ADMIN" because service will add "ROLE_" itself

        when(roleRepository.existsByName("ROLE_ADMIN")).thenReturn(false);
        when(roleRepository.save(any(Role.class))).thenAnswer(invocation -> invocation.getArgument(0)); // 👈 fix here

        Role created = roleService.createRole(role);

        assertEquals("ROLE_ADMIN", created.getName()); // the service adds ROLE_ prefix
        verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void testCreateRoleAlreadyExists() {
        Role role = new Role();
        role.setName("USER"); // 👈 Only "USER", not "ROLE_USER"

        when(roleRepository.existsByName("ROLE_USER")).thenReturn(true);

        assertThrows(RoleAlreadyExistException.class, () -> {
            roleService.createRole(role);
        });
    }

    @Test
    void testAssignRoleToUser() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");

        User user = new User();
        user.setId(2L);
        user.setRoles(new ArrayList<>()); // 🔥 important to initialize roles

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        when(roleRepository.save(role)).thenReturn(role);

        User updatedUser = roleService.assignRoleToUser(2L, 1L);

        assertEquals(2L, updatedUser.getId());
    }

    @Test
    void testRemoveUserFromRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");

        User user = new User();
        user.setId(2L);

        // 🔥 Important: Assign user to role before mocking repository behavior
        role.assignRoleToUser(user);

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        when(roleRepository.save(any(Role.class))).thenReturn(role);

        User updatedUser = roleService.removeUserFromRole(2L, 1L);

        assertEquals(2L, updatedUser.getId());
    }

}
