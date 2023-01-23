package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.model.errors.ErrorTO;
import com.icn.barleystation.model.InventoryRequest;
import com.icn.barleystation.model.InventoryResponse;
import com.icn.barleystation.model.InventoryStack;
import com.icn.barleystation.model.StackRequest;
import com.icn.barleystation.repository.IInventoryRepository;

@Service
@Slf4j
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	private IInventoryRepository inventoryRepo;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Transactional
	@Override
	public ResponseEntity<InventoryResponse> generateInventoryRequest(InventoryRequest request) {
		InventoryResponse response = new InventoryResponse();

		try {
			System.out.println(request.getInventoryRequest().toString());
			request.getInventoryRequest().setItemTag(request.getInventoryRequest().getItem().getIdItem().toString());
			request.getInventoryRequest().setCreatedDate(new Date());
			inventoryRepo.save(request.getInventoryRequest());
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<InventoryResponse>(response, status);
	}

	public List<ErrorTO> retrieveErrors(Exception e) {
		log.error("Errors : " + e.getMessage());
		ErrorTO error = new ErrorTO();
		error.setMessage(e.getLocalizedMessage());
		List<ErrorTO> listError = new ArrayList<ErrorTO>();
		listError.add(error);

		return listError;
	}

	@Transactional
	@Override
	public ResponseEntity<InventoryStack> findStackByItem(String idItem) {

		InventoryStack entityResponse = new InventoryStack();

		try {
			List<InventoryEntity> responseJpa = inventoryRepo.findByIdItem(idItem);
			if (responseJpa.size() > 0) {
				for (InventoryEntity i : responseJpa) {
					System.out.println(i.getStack());
					entityResponse.setStack(i.getStack());

					status = HttpStatus.OK;
				}
			} else {
				status = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			entityResponse.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<InventoryStack>(entityResponse, status);
	}

	@Transactional
	@Override
	public ResponseEntity<InventoryStack> generateInput(StackRequest request, String idItem) {
		InventoryStack response = new InventoryStack();
		Integer stack = null;
		try {
			List<InventoryEntity> responseJpa = inventoryRepo.findByIdItem(idItem);
			if (responseJpa.size() > 0) {
				for (InventoryEntity i : responseJpa) {
					System.out.println(i.getStack());
					stack = i.getStack() + request.getInputs();
				}

				Integer responseUpdate = inventoryRepo.updateStackInp(stack, request.getInputs(), new Date(), idItem);

				if (responseUpdate.equals(1)) {
					response.setStack(stack);
					status = HttpStatus.OK;
				} else {
					status = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			} else {
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<InventoryStack>(response, status);
	}

	@Transactional
	@Override
	public ResponseEntity<InventoryStack> generateOutput(StackRequest request, String idItem) {
		InventoryStack response = new InventoryStack();
		Integer stack = null;
		try {
			List<InventoryEntity> responseJpa = inventoryRepo.findByIdItem(idItem);
			if (responseJpa.size() > 0) {
				for (InventoryEntity i : responseJpa) {
					System.out.println(i.getStack());
					stack = i.getStack() - request.getOutputs();
				}

				if (stack >= 0) {
					Integer responseUpdate = inventoryRepo.updateStackOut(stack, request.getOutputs(), new Date(),
							idItem);

					if (responseUpdate.equals(1)) {
						response.setStack(stack);
						status = HttpStatus.OK;
					} else {
						status = HttpStatus.INTERNAL_SERVER_ERROR;
					}
				} else {
					status = HttpStatus.UNPROCESSABLE_ENTITY;
				}
			} else {
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<InventoryStack>(response, status);
	}

	@Override
	public List<InventoryEntity> getAllFromInventory() {
		List<InventoryEntity> response = new ArrayList<>();
		try {
			response = inventoryRepo.findAll();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return response;
	}

}
