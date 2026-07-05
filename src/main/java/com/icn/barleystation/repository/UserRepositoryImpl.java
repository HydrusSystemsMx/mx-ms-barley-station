package com.icn.barleystation.repository;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.commons.ErrorHandler;
import com.icn.barleystation.entity.UserEntity;
import com.icn.barleystation.mapper.adapter.UserAdapterMapper;
import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserAdapterMapper userAdapterMapper;

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        log.info(CommonsHelper.START + "[createNewUser]");
        UserDTO response = new UserDTO();
        try {
            UserEntity entity = userAdapterMapper.toEntity(userDTO);
            entity.setStatus(true);
            entity.getCreatedDate();
            response = userAdapterMapper.toDTO(userRepository.save(entity));
        } catch (Exception e) {
            response.setErrors(ErrorHandler.retrieveErrors(e));
        }
        log.info(CommonsHelper.END + "[createNewUser]");
        return response;
    }


}
