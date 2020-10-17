package com.andermirik.authentification.repository;

import com.andermirik.authentification.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    RoleModel findByName(String name);
}