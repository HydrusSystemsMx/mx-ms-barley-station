package com.icn.barleystation.dao;

import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;

import java.util.List;

public interface UserDao {
    UserDTO getUserByEmail(String email);
    List<UserResponse> getAllUsers();

    UserDTO getUserById(Long id);
}
