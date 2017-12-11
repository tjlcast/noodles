package com.tjlcast.actors.service.user;

import com.tjlcast.bean.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public interface UserService {
    User findUserById(String userId);

    User findUserByEmail(String email);

    User saveUser(User user);

    String findUserCredentialsByUserId(String userId);

    String saveUserCredentials(String userCredentials);

    void deleteUser(String userId);

    List<User> findTenantUsers(UUID tenantId);

    void deleteTenantUsers(String tenantId);
}
