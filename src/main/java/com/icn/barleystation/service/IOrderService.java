package com.icn.barleystation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.OrderRequest;
import com.icn.barleystation.model.OrderResponse;

public interface IOrderService {

	ResponseEntity<OrderResponse> createNewOrder(OrderRequest request);

	Boolean rollbackRequest(String idRequest);

	ResponseEntity<OrderResponse> getOrderRequest(Integer idUser);

	List<OrderEntity> getCurrentOrders();
}
