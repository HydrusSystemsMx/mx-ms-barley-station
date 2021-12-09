package com.icn.barleystation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.DeliveryRequest;
import com.icn.barleystation.model.DeliveryResponse;
import com.icn.barleystation.service.IDeliveryService;

@RestController
@RequestMapping("/api/v1/barley/delivery/")
public class DeliveryController {

	@Autowired
	private IDeliveryService deliveryService;

	@PostMapping("/add")
	public ResponseEntity<DeliveryResponse> addDelivery(@RequestBody DeliveryRequest request) {
		return deliveryService.addDelivery(request);
	}
}
