package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.ProfileEntity;
import com.icn.barleystation.entity.UserEntity;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.model.UserRequest;
import com.icn.barleystation.model.UserResponse;
import com.icn.barleystation.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository repoUsers;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public ResponseEntity<UserResponse> createNewUser(UserRequest request) {
		UserResponse response = new UserResponse();
		ProfileEntity profile = new ProfileEntity();
		profile.setIdProfile(3);
		
		try {
			request.getRequestUser().setStatus(true);
			request.getRequestUser().setCreatedDate(new Date());
			request.getRequestUser().addProfile(profile);
			repoUsers.save(request.getRequestUser());
			response.setResponse(request.getRequestUser());
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<UserResponse>(response, status);
	}

	@Override
	public ResponseEntity<UserResponse> getUserById(Integer idUser) {
		UserResponse response = new UserResponse();
		try {
			Optional<UserEntity> optional = repoUsers.findById(idUser);
			if (optional.isPresent()) {
				response.setResponse(optional.get());
				status = HttpStatus.OK;
			} else if (optional.isEmpty()) {
				response.setResponse(null);
				status = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<UserResponse>(response, status);
	}

	public List<ErrorTO> retrieveErrors(Exception e) {
		System.out.println("Error: " + e.getMessage());
		ErrorTO error = new ErrorTO();
		error.setMessage(e.getLocalizedMessage());
		List<ErrorTO> listError = new ArrayList<ErrorTO>();
		listError.add(error);

		return listError;
	}

}
