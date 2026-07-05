package com.icn.barleystation.dao;

import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;

import java.util.List;

public interface UserDao {
    UserDTO getUserById(Long id);
    List<UserResponse> getAllUsers();
}
