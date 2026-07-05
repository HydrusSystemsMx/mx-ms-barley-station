package com.icn.barleystation.repository;

import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;

public interface UserRepository {
    UserDTO createNewUser(UserDTO userDTO);
}
