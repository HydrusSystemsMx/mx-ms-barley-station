package com.icn.barleystation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;
import com.icn.barleystation.service.IItemService;

@RestController
@RequestMapping("/api/v1/barley/items")
public class ItemController {

	@Autowired
	private IItemService itemService;

	@PostMapping("/create")
	public ResponseEntity<ItemResponse> createNewItem(@RequestBody RequestItem request) {
		System.out.println("createNewItem()");
		return itemService.createNewItem(request);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemResponse> getItemById(@PathVariable("id") Integer id) {
		System.out.println("getItemById()");
		return itemService.getItemById(id);
	}

	@GetMapping("/all")
	public List<ItemResponse> getAllItems() {
		System.out.println("getAllItems()");
		return itemService.getAllItems();
	}

}
