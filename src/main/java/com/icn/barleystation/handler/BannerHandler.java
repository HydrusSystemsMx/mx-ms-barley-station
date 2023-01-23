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
    private static final String LOG_FIN = "[Fin]";
    private final BannerDao bannerDao;
    private final BannerService bannerService;

    @Autowired
    private BannerModelMapper bannerModelMapper;

    public List<BannerResponse> getAllBanners(){
        return bannerModelMapper.bannerDtoToResponse(bannerDao.getAllBanners());
    }

    public List<BannerResponse> getAllActiveBanners(){
        return bannerModelMapper.bannerDtoToResponse(bannerDao.getAllActiveBanners());
    }

    public void addBanner(BannerRequest bannerRequest){
        bannerService.createNewBanner(bannerModelMapper.requestToBannerDto(bannerRequest));
    }

    public void updateBanner(Long bannerId, BannerRequest bannerRequest){
        bannerService.updateBanner(bannerId, bannerModelMapper.requestToBannerDto(bannerRequest));
    }

}
