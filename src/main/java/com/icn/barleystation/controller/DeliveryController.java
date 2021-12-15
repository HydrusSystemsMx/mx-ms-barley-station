package com.icn.barleystation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.DeliveryOrderStatus;
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

	@GetMapping("/all")
	public ResponseEntity<DeliveryResponse> getAllDeliverys() {
		return deliveryService.getAllDelivery();
	}

	@GetMapping("/retrieveOrders")
	public ResponseEntity<DeliveryOrderStatus> retrieveOrders(@RequestParam("idDelivery") Integer idDelivery) {
		return deliveryService.retrieveOrders(idDelivery);
	}

	@PostMapping("/action/{idRequest}")
	public ResponseEntity<DeliveryOrderStatus> orderAction(@RequestParam("action") String action,
			@PathVariable("idRequest") String idRequest, @RequestParam("idDelivery") Integer idDelivery) {
		return deliveryService.orderAction(action, idRequest, idDelivery);
	}

}
