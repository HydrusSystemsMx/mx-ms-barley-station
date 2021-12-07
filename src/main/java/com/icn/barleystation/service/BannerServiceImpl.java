package com.icn.barleystation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IBannerRepository;

@Service
public class BannerServiceImpl implements IBannerService {

	@Autowired
	private IBannerRepository bannerRepo;

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	@Transactional
	public ResponseEntity<BannerResponse> getAllBanners() {
		BannerResponse response = new BannerResponse();
		List<BannerEntity> responseList = new ArrayList<>();
		try {
			List<BannerEntity> findAllresponse = bannerRepo.findAll();
			for (BannerEntity res : findAllresponse) {
				responseList.add(res);
			}
			response.setResponse(responseList);
			status = HttpStatus.OK;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<BannerResponse>(response, status);
	}

	@Override
	@Transactional
	public ResponseEntity<BannerResponse> addBanner(BannerRequest banner) {
		BannerResponse response = new BannerResponse();
		List<BannerEntity> responseList = new ArrayList<>();
		try {
			BannerEntity request = new BannerEntity();
			request.setCreatedDate(new Date());
			request.setStatus(true);
			request.setUrl(banner.getUrl());
			bannerRepo.save(request);
			status = HttpStatus.CREATED;
			responseList.add(request);
			response.setResponse(responseList);
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<BannerResponse>(response, status);
	}

	@Override
	@Transactional
	public ResponseEntity<BannerResponse> changeStatusBanner(Boolean statusBanner, Integer idBanner) {
		BannerResponse response = new BannerResponse();
		try {
			Integer res = bannerRepo.cahngeBannerStatus(statusBanner, idBanner);
			if (res.equals(1)) {
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<BannerResponse>(response, status);
	}

	@Override
	@Transactional
	public ResponseEntity<BannerResponse> getAllActiveBanners() {
		BannerResponse response = new BannerResponse();
		List<BannerEntity> responseList = new ArrayList<>();
		try {
			List<BannerEntity> findAllresponse = bannerRepo.findAllActive(true);
			for (BannerEntity res : findAllresponse) {
				responseList.add(res);
			}
			response.setResponse(responseList);
			status = HttpStatus.OK;
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return new ResponseEntity<BannerResponse>(response, status);
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
