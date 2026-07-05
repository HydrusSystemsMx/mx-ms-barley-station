package com.icn.barleystation.service;

import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;
import com.icn.barleystation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDTO createNewUser(UserDTO userDTO){
        return userRepository.createNewUser(userDTO);
    }
}
