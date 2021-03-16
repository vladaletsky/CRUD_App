package com.wladyslaw.crudApp.repository;

import com.wladyslaw.crudApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1%")
User findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String name, String lastName);
}
