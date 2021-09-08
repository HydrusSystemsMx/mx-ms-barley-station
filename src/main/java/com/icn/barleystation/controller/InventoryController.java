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

import com.icn.barleystation.model.InventoryRequest;
import com.icn.barleystation.model.InventoryResponse;
import com.icn.barleystation.model.InventoryStack;
import com.icn.barleystation.model.StackRequest;
import com.icn.barleystation.service.IInventoryService;

@RestController
@RequestMapping("/api/v1/barley/inventory")
public class InventoryController {

	@Autowired
	private IInventoryService inventoryService;

	@PostMapping("/create")
	public ResponseEntity<InventoryResponse> inventoryRequest(@RequestBody InventoryRequest request) {
		System.out.println("inventoryRequest() " + request.getInventoryRequest().toString());
		return inventoryService.generateInventoryRequest(request);
	}

	@GetMapping("/stack/{idItem}")
	public ResponseEntity<InventoryStack> getStackByItem(@PathVariable("idItem") String idItem) {
		System.out.println("getStackByItem() " + idItem);
		return inventoryService.findStackByItem(idItem);
	}

	@PostMapping("/stack/inputs/{idItem}")
	public ResponseEntity<InventoryStack> generateInput(@PathVariable("idItem") String idItem,
			@RequestBody StackRequest request) {
		System.out.println("generateInput() ");
		if (validateRequest(request, 1)) {
			return inventoryService.generateInput(request, idItem);
		} else {
			InventoryStack response = new InventoryStack();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/stack/outputs/{idItem}")
	public ResponseEntity<InventoryStack> generateOutput(@PathVariable("idItem") String idItem,
			@RequestBody StackRequest request) {
		System.out.println("generateOutput() ");
		if (validateRequest(request, 0)) {
			return inventoryService.generateOutput(request, idItem);
		} else {
			InventoryStack response = new InventoryStack();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	public Boolean validateRequest(StackRequest request, Integer event) {
		// 1 = iput , 2 == output
		Boolean validRequest = false;
		if (event == 1) {
			if (request.getInputs() != null) {
				return true;
			}
		} else {
			if (request.getOutputs() != null) {
				return true;
			}
		}

		return validRequest;
	}

}
