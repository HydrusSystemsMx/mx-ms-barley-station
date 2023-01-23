package com.icn.barleystation.dao;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.mapper.adapter.BrandModelMapper;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.repository.IBrandJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.icn.barleystation.commons.ErrorHandler.retrieveErrors;


@Slf4j
@RequiredArgsConstructor
@Component
public class BrandDaoImpl implements BrandDao{
    @Autowired
    private IBrandJpaRepository brandRepo;
    @Autowired
    private final BrandModelMapper brandModelMapper;

    @Override
    public BrandResponse getBrandById(Long id) {
        BrandResponse response = new BrandResponse();
        try {
            Optional<BrandEntity> optional = brandRepo.findById(id);
            if (optional.isPresent()) {
                response = brandModelMapper.brandEntityToResponse(optional.get());
            }
        } catch (Exception e) {
            response.setErrors(retrieveErrors(e));
        }
        return response;
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        List<BrandResponse> response = new ArrayList<>();
        try {
            List<BrandEntity> allItems = brandRepo.findAll();

            for (BrandEntity list : allItems) {
                BrandResponse brandResponse = brandModelMapper.brandEntityToResponse(list);
                response.add(brandResponse);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return response;
    }

    @Override
    public boolean getBrandByBrandName(String brandName) {
        BrandEntity bannerEntity = brandRepo.findByBrandName(brandName);
        return Objects.nonNull(bannerEntity);
    }
}
