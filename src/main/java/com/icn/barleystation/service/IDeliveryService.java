package com.icn.barleystation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.entity.DeliveryEntity;
import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.DeliveryOrderStatus;
import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;

public interface IDeliveryService {

	public ResponseEntity<DeliveryResponse> addDelivery(DeliveryRequest request);

	public ResponseEntity<DeliveryResponse> getAllDelivery();

	List<DeliveryEntity> getDeliveryAvaliable();

	public void assignToDelivery(DeliveryEntity delivery, List<OrderEntity> orderTaken);

	public ResponseEntity<DeliveryOrderStatus> orderAction(String action, String idRequest, Integer idDelivery);

	public ResponseEntity<DeliveryOrderStatus> retrieveOrders(Integer idDelivery);
}
