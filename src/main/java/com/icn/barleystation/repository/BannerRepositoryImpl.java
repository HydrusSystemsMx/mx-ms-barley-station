package com.icn.barleystation.repository;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.mapper.adapter.BannerAdapterMapper;
import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.model.ErrorTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class BannerRepositoryImpl implements BannerRepository{
    private static final String INICIO = "[Inicio]";
    private static final String FIN = "[Fin]";
    @Autowired
    private IBannerJpaRepository bannerRepo;

    @Autowired
    private BannerAdapterMapper bannerAdapterMapper;

    @Autowired
    private BannerModelMapper bannerModelMapper;

	@Override
	@Transactional
	public void addBanner(BannerDTO banner) {
        log.info(INICIO);
		try {
			BannerEntity bannerEntity = bannerAdapterMapper.toEntity(banner);
			bannerEntity.setStatus(true);
			bannerRepo.save(bannerEntity);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
        log.info(FIN);
	}

	@Override
	@Transactional
	public void updateBanner(Long bannerId, BannerDTO banner) {
        log.info(INICIO);
		try {
			Optional<BannerEntity> bannerEntity = bannerRepo.findById(bannerId);

			if(bannerEntity.isPresent()){
				bannerEntity.get().setUrl(banner.getUrl());
				bannerEntity.get().setStatus(banner.isStatus());
				bannerRepo.save(bannerEntity.get());
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
        log.info(FIN);
	}

	public List<ErrorTO> retrieveErrors(Exception e) {
		ErrorTO error = new ErrorTO();
		error.setMessage(e.getLocalizedMessage());
		List<ErrorTO> listError = new ArrayList<>();
		listError.add(error);

		return listError;
	}
}
