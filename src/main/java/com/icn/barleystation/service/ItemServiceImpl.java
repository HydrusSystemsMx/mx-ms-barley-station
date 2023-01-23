package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.model.errors.ErrorTO;
import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;
import com.icn.barleystation.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepository repoItem;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public ResponseEntity<ItemResponse> createNewItem(RequestItem request) {
		ItemResponse response = new ItemResponse();
		System.out.println("req " + request.toString());
		try {
			request.getRequestItem().setStatus(true);
			request.getRequestItem().setCreatedDate(new Date());
			repoItem.save(request.getRequestItem());
			response.setResponse(request.getRequestItem());
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<ItemResponse>(response, status);
	}

	@Override
	public ResponseEntity<ItemResponse> getItemById(Integer id) {
		ItemResponse response = new ItemResponse();
		try {
			Optional<ItemEntity> optional = repoItem.findById(id);
			if (optional.isPresent()) {
				response.setResponse(optional.get());
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<ItemResponse>(response, status);
	}

	@Override
	public List<ItemResponse> getAllItems(List<InventoryEntity> itemsInInventory) {
		List<ItemResponse> response = new ArrayList<ItemResponse>();
		List<Integer> idItemsInv = new ArrayList<>();

		for (InventoryEntity i : itemsInInventory) {
			idItemsInv.add(i.getItem().getIdItem());
		}

		try {
			List<ItemEntity> allItems = repoItem.findAllById(idItemsInv);

			for (ItemEntity list : allItems) {
				for (InventoryEntity i : itemsInInventory) {
					if (list.getIdItem().equals(i.getItem().getIdItem()) && i.getStack() > 0) {
						ItemResponse itemResponse = new ItemResponse();
						itemResponse.setResponse(list);
						itemResponse.setStack(i.getStack());
						response.add(itemResponse);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return response;
	}

	public List<ErrorTO> retrieveErrors(Exception e) {
		System.out.println("Error: " + e.getMessage());
		ErrorTO error = new ErrorTO();
		error.setMessage(e.getLocalizedMessage());
		List<ErrorTO> listError = new ArrayList<ErrorTO>();
		listError.add(error);

		return listError;
	}

	@Override
	public List<ItemResponse> getItemByIdBrand(BrandEntity brand, List<InventoryEntity> itemsInInventory) {
		List<ItemResponse> response = new ArrayList<ItemResponse>();

		try {
			List<ItemEntity> allItems = repoItem.findByBrand(brand);

			for (int i = 0; i < itemsInInventory.size(); i++) {
				for (int j = 0; j < allItems.size(); j++) {
					if (itemsInInventory.get(i).getItem().getIdItem().equals(allItems.get(j).getIdItem())
							&& itemsInInventory.get(i).getStack() > 0) {
						ItemResponse obj = new ItemResponse();
						obj.setResponse(allItems.get(j));
						obj.setStack(itemsInInventory.get(i).getStack());
						response.add(obj);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return response;

	}

	@Override
	public List<ItemResponse> getAll() {
		List<ItemResponse> response = new ArrayList<>();
		List<ItemEntity> jpa = repoItem.findAll();
		for (ItemEntity i : jpa) {
			ItemResponse objRes = new ItemResponse();
			objRes.setResponse(i);
			response.add(objRes);
		}
		return response;
	}

}
