package com.wladyslaw.crudApp.repository;

import com.wladyslaw.crudApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1%")
    User search(String name);
}
