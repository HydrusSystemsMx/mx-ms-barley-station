package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.DeliveryEntity;
import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IDeliveryRpository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Autowired
	private IDeliveryRpository deliveryRepo;

	@Override
	@Transactional
	public ResponseEntity<DeliveryResponse> addDelivery(DeliveryRequest request) {
		DeliveryResponse response = new DeliveryResponse();
		List<DeliveryEntity> responseList = new ArrayList<>();
		try {
			request.getRequest().setCreatedDate(new Date());
			deliveryRepo.save(request.getRequest());
			status = HttpStatus.CREATED;
			responseList.add(request.getRequest());
			response.setResponse(responseList);
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<DeliveryResponse>(response, status);
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
