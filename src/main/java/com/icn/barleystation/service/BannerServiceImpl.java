package com.icn.barleystation.service;

import java.util.*;

import javax.transaction.Transactional;

import com.icn.barleystation.mapper.adapter.BannerAdapterMapper;
import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IBannerRepository;

@Service
@Slf4j
public class BannerServiceImpl implements IBannerService {

	@Autowired
	private IBannerRepository bannerRepo;

	@Autowired
	private BannerAdapterMapper bannerAdapterMapper;

	@Autowired
	private BannerModelMapper bannerModelMapper;

	@Override
	@Transactional
	public List<BannerDTO> getAllBanners() {
		BannerResponse response = new BannerResponse();
		List<BannerDTO> responseList = new ArrayList<>();
		try {
			responseList = bannerAdapterMapper.toDTOS(bannerRepo.findAllByOrderByIdDesc());
		} catch (Exception e) {
			response.setErrors(retrieveErrors(e));
		}
		return responseList;
	}

	@Override
	@Transactional
	public void addBanner(BannerDTO banner) {
		try {
			BannerEntity bannerEntity = bannerAdapterMapper.toEntity(banner);
			bannerEntity.setFechaCreacion(new Date());
			bannerEntity.setStatus(true);
			bannerRepo.save(bannerEntity);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public void actualizarBanner(Long id, BannerDTO banner) {
		try {
			Optional<BannerEntity> bannerEntity = bannerRepo.findById(id);

			if(bannerEntity.isPresent()){
				bannerEntity.get().setUltimaModificacion(new Date());
				bannerEntity.get().setUrl(banner.getUrl());
				bannerEntity.get().setStatus(banner.isStatus());
				bannerRepo.save(bannerEntity.get());
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public List<BannerDTO> getAllActiveBanners() {
		BannerResponse response = new BannerResponse();
		List<BannerDTO> responseList = new ArrayList<>();
		try {
			responseList = bannerAdapterMapper.toDTOS(bannerRepo.findAllActiveOrderByIdDesc(true));
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setErrors(retrieveErrors(e));
		}
		return responseList;
	}

	public List<ErrorTO> retrieveErrors(Exception e) {
		ErrorTO error = new ErrorTO();
		error.setMessage(e.getLocalizedMessage());
		List<ErrorTO> listError = new ArrayList<>();
		listError.add(error);

		return listError;
	}

}
