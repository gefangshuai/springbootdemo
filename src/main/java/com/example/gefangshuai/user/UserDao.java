package com.example.gefangshuai.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by gefangshuai on 2015/11/3.
 */
public interface UserDao extends JpaRepository<CustomUser, Long>,JpaSpecificationExecutor<CustomUser> {
    CustomUser findByEmail(String email);

    CustomUser findByName(String name);
}
