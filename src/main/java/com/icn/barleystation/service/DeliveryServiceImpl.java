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
import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IDeliveryRpository;
import com.icn.barleystation.repository.IOrderRepository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Autowired
	private IDeliveryRpository deliveryRepo;

	@Autowired
	private IOrderRepository orderRepo;

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

	@Override
	public ResponseEntity<DeliveryResponse> getAllDelivery() {
		DeliveryResponse response = new DeliveryResponse();
		List<DeliveryEntity> responseList = new ArrayList<>();
		try {
			responseList = deliveryRepo.findAll();
			status = HttpStatus.OK;
			response.setResponse(responseList);
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<DeliveryResponse>(response, status);
	}

	@Override
	public List<DeliveryEntity> getDeliveryAvaliable() {
		DeliveryResponse response = new DeliveryResponse();
		List<DeliveryEntity> responseList = new ArrayList<>();
		try {
			responseList = deliveryRepo.findDeliveryAvaliable(false);
			status = HttpStatus.OK;
			response.setResponse(responseList);
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return responseList;
	}

	@Override
	@Transactional
	public void assignToDelivery(DeliveryEntity delivery, List<OrderEntity> orderTaken) {
		System.out.println("updateInfoDeliveryInOrder()");
		orderRepo.updateInfoDeliveryInOrder(1, new Date(), delivery.getIdDelivery(), orderTaken.get(0).getIdRequest());
		System.out.println("changeStatusOrder()");
		orderRepo.changeStatusOrder(orderTaken.get(0).getIdRequest(), 1);
		System.out.println("updateDeliveryStatus()");
		deliveryRepo.updateDeliveryStatus(delivery.getIdDelivery(), true);

		System.out.println("assignToDelivery() Orden: " + orderTaken.get(0).getIdRequest() + " tomada por: "
				+ delivery.getName() + " " + delivery.getSecondName());

	}

}
