package com.icn.barleystation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;
import com.icn.barleystation.service.IBrandService;
import com.icn.barleystation.service.IInventoryService;
import com.icn.barleystation.service.IItemService;

@RestController
@RequestMapping("/api/v1/barley/items")
public class ItemController {

	@Autowired
	private IItemService itemService;

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IInventoryService inventoryService;

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

	@GetMapping("/search")
	public List<ItemResponse> getItemByIdBrand(@RequestParam("idBrand") Integer id) {
		System.out.println("getItemByIdBrand()");
		List<InventoryEntity> itemsInInventory = inventoryService.getAllFromInventory();
		ResponseEntity<BrandResponse> brand = brandService.getBrandById(id);

		return itemService.getItemByIdBrand(brand.getBody().getResponse(), itemsInInventory);
	}

	@GetMapping("/all")
	public List<ItemResponse> getAllItems() {
		System.out.println("getAllItems()");
		List<InventoryEntity> itemsInInventory = inventoryService.getAllFromInventory();
		return itemService.getAllItems(itemsInInventory);
	}

	@GetMapping("/allOut")
	public List<ItemResponse> getAll() {
		System.out.println("getAllItemss()");
		return itemService.getAll();
	}

}
