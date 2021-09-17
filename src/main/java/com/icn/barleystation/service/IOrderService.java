package com.icn.barleystation.service;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.OrderRequest;
import com.icn.barleystation.model.OrderResponse;

public interface IOrderService {

	ResponseEntity<OrderResponse> createNewOrder(OrderRequest request);

	Boolean rollbackRequest(Integer idRequest);
}
