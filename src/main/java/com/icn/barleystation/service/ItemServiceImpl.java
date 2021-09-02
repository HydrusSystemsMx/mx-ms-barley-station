package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.model.ErrorTO;
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
			} else if (optional.isEmpty()) {
				status = HttpStatus.NOT_FOUND;
				response = null;
			}
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<ItemResponse>(response, status);
	}

	@Override
	public List<ItemResponse> getAllItems() {
		List<ItemResponse> response = new ArrayList<ItemResponse>();
		try {
			List<ItemEntity> allItems = repoItem.findAll();

			for (ItemEntity list : allItems) {
				ItemResponse itemResponse = new ItemResponse();
				itemResponse.setResponse(list);
				response.add(itemResponse);
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

}
