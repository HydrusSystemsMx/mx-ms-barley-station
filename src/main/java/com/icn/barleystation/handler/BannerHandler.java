package com.icn.barleystation.handler;

import com.icn.barleystation.dao.BannerDao;
import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.service.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BannerHandler {
    private static final String LOG_INICIO = "[Inicio]";
    private final BannerDao bannerDao;
    private final BannerService bannerService;

    @Autowired
    private BannerModelMapper bannerModelMapper;

    public List<BannerResponse> getAllBanners(){
        log.info(LOG_INICIO);
        return bannerModelMapper.bannerDtoToResponse(bannerDao.getAllBanners());
    }

    public List<BannerResponse> getAllActiveBanners(){
        log.info(LOG_INICIO);
        return bannerModelMapper.bannerDtoToResponse(bannerDao.getAllActiveBanners());
    }

    public void addBanner(BannerRequest bannerRequest){
        log.info(LOG_INICIO);
        bannerService.createNewBanner(bannerModelMapper.requestToBannerDto(bannerRequest));
    }

    public void updateBanner(Long bannerId, BannerRequest bannerRequest){
        log.info(LOG_INICIO);
        bannerService.updateBanner(bannerId, bannerModelMapper.requestToBannerDto(bannerRequest));
    }

}
