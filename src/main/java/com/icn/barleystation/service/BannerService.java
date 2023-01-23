package com.icn.barleystation.service;

import com.icn.barleystation.dao.BannerDao;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerDao bannerDao;
    private final BannerRepository bannerRepository;

    public void createNewBanner(BannerDTO bannerDTO){
        if(!bannerDao.getBannerByUrl(bannerDTO.getUrl())){
            bannerRepository.addBanner(bannerDTO);
        } else{
            log.info("Ya eciste el banner");
        }
    }

    public void updateBanner(Long bannerId, BannerDTO bannerDTO){
        if(bannerDao.getBannerById(bannerId)){
            bannerRepository.updateBanner(bannerId, bannerDTO);
        } else{
            log.info("No eciste el banner");
        }
    }


}
