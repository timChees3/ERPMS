package com.toinfinityandbeyong.ERPMS.service.interfaces;

import com.toinfinityandbeyong.ERPMS.dto.request.SignupRequest;
import com.toinfinityandbeyong.ERPMS.dto.response.UserResponse;

import java.util.List;

public interface UserService
{
    UserResponse createUser(SignupRequest signupRequest);
    UserResponse getUserById(Long id);
    UserResponse getUserByUsername(String username);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, SignupRequest signupRequest);
    void deleteUser(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
