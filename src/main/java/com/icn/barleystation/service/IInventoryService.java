package com.icn.barleystation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.model.InventoryRequest;
import com.icn.barleystation.model.InventoryResponse;
import com.icn.barleystation.model.InventoryStack;
import com.icn.barleystation.model.StackRequest;

public interface IInventoryService {

	ResponseEntity<InventoryResponse> generateInventoryRequest(InventoryRequest request);

	ResponseEntity<InventoryStack> findStackByItem(String idItem);

	ResponseEntity<InventoryStack> generateInput(StackRequest request, String idItem);

	ResponseEntity<InventoryStack> generateOutput(StackRequest request, String idItem);

	List<InventoryEntity> getAllFromInventory();
}
