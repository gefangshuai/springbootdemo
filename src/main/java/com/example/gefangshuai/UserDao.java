package com.example.gefangshuai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by gefangshuai on 2015/11/3.
 */
public interface UserDao extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {
    User findByEmail(String email);
}
