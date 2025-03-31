package com.eevee.HotelBookingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eevee.HotelBookingApplication.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String role);

    boolean existsByName(String role);
}
