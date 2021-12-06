package com.icn.barleystation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.icn.barleystation.model.InventoryStack;
import com.icn.barleystation.model.OrderRequest;
import com.icn.barleystation.model.OrderResponse;
import com.icn.barleystation.model.StackRequest;
import com.icn.barleystation.service.IInventoryService;
import com.icn.barleystation.service.IOrderService;

@RestController
@RequestMapping("/api/v1/barley/order/")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IInventoryService inventoryService;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@PostMapping("/create")
	public ResponseEntity<OrderResponse> createNewOrder(@RequestBody OrderRequest request) {
		OrderResponse fullResponse = new OrderResponse();
		System.out.println("createNewOrder()");

		ResponseEntity<OrderResponse> responseOEntity = orderService.createNewOrder(request);

		if (responseOEntity.getBody().getErrors() == null) {
			System.out.println("Success");
			for (int i = 0; i < request.getOrderList().size(); i++) {
				System.out.println("stack upd");
				StackRequest stackOut = new StackRequest();
				stackOut.setOutputs(request.getOrderList().get(i).getAmount());
				ResponseEntity<InventoryStack> uptOut = inventoryService.generateOutput(stackOut,
						request.getOrderList().get(i).getIdItem().toString());
				if (uptOut.getBody().getErrors() == null) {
					status = HttpStatus.CREATED;
					System.out.println("inventory res: " + uptOut.getBody().getStack());
				} else {
					throw new RestClientException(uptOut.getBody().getErrors().toString());
				}
			}

		} else {
			status = orderService.createNewOrder(request).getStatusCode();
			fullResponse.setErrors(orderService.createNewOrder(request).getBody().getErrors());
		}

		return new ResponseEntity<OrderResponse>(fullResponse, status);
	}

	@PostMapping("/rollback/{idRequest}")
	public Boolean rollBackOrder(@PathVariable("idRequest") String idRequest) {
		System.out.println("rollBackOrder()" + idRequest);

		return orderService.rollbackRequest(idRequest);
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<OrderResponse> getBarleyRequest(@PathVariable("idUser") Integer idUser) {
		System.out.println("getBarleyRequest()" + idUser);
		return orderService.getOrderRequest(idUser);
	}
}
