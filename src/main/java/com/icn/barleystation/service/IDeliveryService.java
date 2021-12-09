package com.icn.barleystation.service;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;

public interface IDeliveryService {

	public ResponseEntity<DeliveryResponse> addDelivery(DeliveryRequest request);
}
