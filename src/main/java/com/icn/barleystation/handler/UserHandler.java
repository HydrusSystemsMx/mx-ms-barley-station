package com.icn.barleystation.handler;

import com.icn.barleystation.dao.UserDao;
import com.icn.barleystation.mapper.adapter.UserModelMapper;
import com.icn.barleystation.model.*;
import com.icn.barleystation.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class UserHandler {
    private final UserService userService;
    private final UserModelMapper userModelMapper;
    private final UserDao userDao;

    public UserResponse createNewUser(UserRequest userRequest) {
        UserDTO userDTO = userModelMapper.requestToUserDto(userRequest);
        return userModelMapper.userDtoToResponse(userService.createNewUser(userDTO));

    }

    public UserResponse getUserById(Long id) {
        return userModelMapper.userDtoToResponse(userDao.getUserById(id));
    }
}
