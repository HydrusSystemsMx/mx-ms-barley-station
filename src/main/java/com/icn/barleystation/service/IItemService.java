package com.icn.barleystation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;

public interface IItemService {

	ResponseEntity<ItemResponse> createNewItem(RequestItem request);

	ResponseEntity<ItemResponse> getItemById(Integer id);

	List<ItemResponse> getAllItems();
}
