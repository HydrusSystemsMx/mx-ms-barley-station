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
import com.icn.barleystation.model.DeliveryOrderStatus;
import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;
import com.icn.barleystation.model.errors.ErrorTO;
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

	@Override
	@Transactional
	public ResponseEntity<DeliveryOrderStatus> orderAction(String action, String idRequest, Integer idDelivery) {
		DeliveryOrderStatus response = new DeliveryOrderStatus();
		Integer responseUpdate = null;
		try {
			DeliveryEntity deliveryInfo = deliveryRepo.findByIdDelivery(idDelivery);
			System.out.println(
					"Delivery: " + deliveryInfo.retrieveFullName() + " action: " + action + " request: " + idRequest);


			if (action.equals("TAKE")) {
				responseUpdate = orderRepo.updateStatusDelivery(2, new Date(), idRequest);
			} else if (action.equals("FINISH")) {
				responseUpdate = orderRepo.updateStatusDelivery(3, new Date(), idRequest);
			} else {
				//APLICAR ROLLBACK NORMAL
				responseUpdate = orderRepo.updateStatusDelivery(4, new Date(), idRequest);
			}

			if(responseUpdate.equals(3)) {
				response.setErrors(null);
				response.setName(deliveryInfo.retrieveFullName());
				response.setAction(action);
				status = HttpStatus.OK;
				
			} else {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				throw new Exception("Error al actualizar la request");
			}
			
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<DeliveryOrderStatus>(response, status);
	}

	@Override
	@Transactional
	public ResponseEntity<DeliveryOrderStatus> retrieveOrders(Integer idDelivery) {
		DeliveryOrderStatus response = new DeliveryOrderStatus();
		List<OrderEntity> orders = new ArrayList<>();
		try {
			List<OrderEntity> responseJpa = orderRepo.findIdRequestByIdDeliveryAndStatus(idDelivery, 1);
			DeliveryEntity deliveryInfo = deliveryRepo.findByIdDelivery(idDelivery);

			if (responseJpa.isEmpty()) {
				status = HttpStatus.NOT_FOUND;
				throw new Exception("No se encontraron pedidos por atender");
			}

			for (OrderEntity temp : responseJpa) {
				orders.add(temp);
			}

			response.setName(deliveryInfo.retrieveFullName());
			response.setErrors(null);
			response.setCurrentOrder(orders);

			status = HttpStatus.OK;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<DeliveryOrderStatus>(response, status);
	}

}
