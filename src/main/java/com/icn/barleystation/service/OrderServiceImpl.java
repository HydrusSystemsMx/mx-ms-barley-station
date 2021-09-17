package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.OrderRequest;
import com.icn.barleystation.model.OrderResponse;
import com.icn.barleystation.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public ResponseEntity<OrderResponse> createNewOrder(OrderRequest request) {
		System.out.println("entraa");
		OrderResponse response = new OrderResponse();
		List<OrderEntity> responseList = new ArrayList<>();

		try {
			for (int i = 0; i < request.getOrderList().size(); i++) {
				OrderEntity order = new OrderEntity();
				order.setIdRequest(request.getIdRequest());
				order.setIdItem(request.getOrderList().get(i).getIdItem());
				order.setCreatedDate(new Date());
				order.setAmount(request.getOrderList().get(i).getAmount());
				order.setIdUser(request.getOrderList().get(i).getIdUser());
				order.setDeliveryLocation(request.getDeliveryLocation());
				order.setTotal(request.getTotal());
				order.setMoneyPrice(request.getOrderList().get(i).getMoneyPrice());

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

}
