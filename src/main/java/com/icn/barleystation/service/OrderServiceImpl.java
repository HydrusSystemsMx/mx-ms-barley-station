package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.OrderRequest;
import com.icn.barleystation.model.OrderResponse;
import com.icn.barleystation.repository.IInventoryRepository;
import com.icn.barleystation.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;

	@Autowired
	IInventoryRepository invRepo;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public ResponseEntity<OrderResponse> createNewOrder(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		List<OrderEntity> responseList = new ArrayList<>();

		try {
			for (int i = 0; i < request.getOrderList().size(); i++) {
				OrderEntity order = new OrderEntity();
				order.setIdRequest(request.getIdRequest());
				order.setIdItem(request.getOrderList().get(i).getIdItem());
				order.setCreatedDate(new Date());
				order.setAmount(request.getOrderList().get(i).getAmount());
				order.setIdUser(request.getIdUser());
				order.setDeliveryLocation(request.getDeliveryLocation());
				order.setTotal(request.getTotal());
				order.setPayMethod(request.getPayMethod());
				order.setPrice(request.getOrderList().get(i).getPrice());
				order.setStatus(0);

				orderRepo.save(order);
				responseList.add(order);
				status = HttpStatus.CREATED;
			}
			response.setResponse(responseList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<OrderResponse>(response, status);
	}

	@Override
	@Transactional
	public Boolean rollbackRequest(String idRequest) {
		System.out.println("rollbackRequest()");
		Boolean response = false;
		try {
			List<OrderEntity> request = orderRepo.findAllByIdRequest(idRequest);
			
			System.out.println("**** " + request.toString());
			
			for (OrderEntity o : request) {
				System.out.println("Item: " + o.getIdItem().toString() );
				InventoryEntity stack = invRepo.findStackByItemTag(o.getIdItem().toString());
				System.out.println(" Stack: " + stack.getStack());
				Integer rollbackStack = stack.getStack() + o.getAmount();
				System.out.println("stack " + rollbackStack);
				Integer responseUpdate = invRepo.updateStackInp(rollbackStack, o.getAmount(), new Date(),
						o.getIdItem().toString());
				if (responseUpdate.equals(1)) {
					status = HttpStatus.OK;
				} else {
					status = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			} 
			Integer rollBackedStatus = orderRepo.rollBackStatus(idRequest, 3);
			System.out.println("rollBackedStatus " + rollBackedStatus);
			if (rollBackedStatus > 0) {
				response = true;
			}
		} catch (Exception e) {
			System.out.println("err: " + e.getLocalizedMessage());
		}

		return response;
	}

	@Override
	public ResponseEntity<OrderResponse> getOrderRequest(Integer idUser) {
		OrderResponse response = new OrderResponse();
		try {
			List<OrderEntity> order = orderRepo.findByIdUser(idUser, 0);
			if (order != null) {
				for (OrderEntity e : order) {
					System.out.println(e.toString());
				}
				response.setResponse(order);
				status = HttpStatus.OK;
			} else {
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			System.out.println("err: " + e.getLocalizedMessage());
		}
		return new ResponseEntity<OrderResponse>(response, status);
	}

}
