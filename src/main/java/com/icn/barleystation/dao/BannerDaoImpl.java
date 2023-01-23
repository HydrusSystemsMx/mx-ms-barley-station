package com.icn.barleystation.dao;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.mapper.adapter.BannerAdapterMapper;
import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.model.ErrorTO;
import com.icn.barleystation.repository.IBannerJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Component
public class BannerDaoImpl implements BannerDao{

    private static final String LOG_INICIO = "[Inicio]";
    private static final String LOG_FIN = "[Fin]";

    @Autowired
    private IBannerJpaRepository bannerRepo;

    @Autowired
    private BannerAdapterMapper bannerAdapterMapper;

    @Autowired
    private BannerModelMapper bannerModelMapper;

    @Override
    public List<BannerDTO> getAllBanners() {
        log.info(LOG_INICIO);
        BannerResponse response = new BannerResponse();
        List<BannerDTO> responseList = new ArrayList<>();
        try {
            responseList = bannerAdapterMapper.toDTOS(bannerRepo.findAllByOrderByIdDesc());
        } catch (Exception e) {
            response.setErrors(retrieveErrors(e));
        }
        log.info(LOG_FIN);
        return responseList;
    }

    @Override
    public List<BannerDTO> getAllActiveBanners() {
        log.info(LOG_INICIO);
        BannerResponse response = new BannerResponse();
        List<BannerDTO> responseList = new ArrayList<>();
        try {
            responseList = bannerAdapterMapper.toDTOS(bannerRepo.findAllActiveOrderByIdDesc(true));
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setErrors(retrieveErrors(e));
        }
        log.info(LOG_FIN);
        return responseList;
    }

    @Override
    public boolean getBannerByUrl(String bannerUrl) {
       BannerEntity bannerEntity = bannerRepo.findByUrl(bannerUrl);
        return Objects.nonNull(bannerEntity);
    }

    @Override
    public boolean getBannerById(Long bannerId) {
        Optional<BannerEntity> bannerEntity = bannerRepo.findById(bannerId);
        return Objects.nonNull(bannerEntity);
    }

    public List<ErrorTO> retrieveErrors(Exception e) {
        ErrorTO error = new ErrorTO();
        error.setMessage(e.getLocalizedMessage());
        List<ErrorTO> listError = new ArrayList<>();
        listError.add(error);

        return listError;
    }

}
