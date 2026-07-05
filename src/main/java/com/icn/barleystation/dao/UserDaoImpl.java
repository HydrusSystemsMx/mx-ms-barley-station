package com.icn.barleystation.dao;

import com.icn.barleystation.mapper.adapter.UserAdapterMapper;
import com.icn.barleystation.mapper.adapter.UserModelMapper;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;
import com.icn.barleystation.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.icn.barleystation.commons.ErrorHandler.retrieveErrors;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDaoImpl implements UserDao{

    private static final String LOG_INICIO = "[Inicio]";
    private static final String LOG_FIN = "[Fin]";

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserAdapterMapper userAdapterMapper;

    @Autowired
    private UserModelMapper userModelMapper;
    @Override
    public UserDTO getUserById(Long id) {
        log.info(LOG_INICIO);
        UserDTO response = new UserDTO();
        try {
            response = userAdapterMapper.toDTO(userRepository.findByIdUser(id));
        } catch (Exception e) {
            response.setErrors(retrieveErrors(e));
        }
        log.info(LOG_FIN);
        return response;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }
}
