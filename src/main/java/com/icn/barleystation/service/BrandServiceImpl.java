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
import com.icn.barleystation.model.BrandRequest;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IBrandRepository;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private IBrandRepository brandRepo;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public ResponseEntity<BrandResponse> createNewBrand(BrandRequest request) {
		BrandResponse response = new BrandResponse();
		try {
			request.getRequestBrand().setStatus(true);
			request.getRequestBrand().setCreatedDate(new Date());
			brandRepo.save(request.getRequestBrand());
			response.setResponse(request.getRequestBrand());
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}

		return new ResponseEntity<BrandResponse>(response, status);
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
	public ResponseEntity<BrandResponse> getBrandById(Integer id) {
		BrandResponse response = new BrandResponse();
		try {
			Optional<BrandEntity> optional = brandRepo.findById(id);
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
		return new ResponseEntity<BrandResponse>(response, status);
	}

	@Override
	public List<BrandResponse> getAllBrands() {
		List<BrandResponse> response = new ArrayList<BrandResponse>();
		try {
			List<BrandEntity> allItems = brandRepo.findAll();

			for (BrandEntity list : allItems) {
				BrandResponse brandResponse = new BrandResponse();
				brandResponse.setResponse(list);
				response.add(brandResponse);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return response;
	}

}
