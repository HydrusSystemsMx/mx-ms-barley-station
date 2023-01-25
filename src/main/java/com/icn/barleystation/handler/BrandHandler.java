package com.icn.barleystation.handler;

import com.icn.barleystation.dao.BrandDao;
import com.icn.barleystation.mapper.adapter.BrandModelMapper;
import com.icn.barleystation.model.BrandRequest;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BrandHandler {
    private final BrandDao brandDao;
    private final BrandService brandService;
    private final BrandModelMapper brandModelMapper;

    public void createNewBrand(BrandRequest request) {
        brandService.createNewBrand(brandModelMapper.requestToBrandDto(request));
    }

    public BrandResponse getBrandById(Long id) {
        return brandModelMapper.brandDtoToResponse(brandDao.getBrandById(id));
    }

    public List<BrandResponse> getAllBrands() {
        return brandDao.getAllBrands();
    }
}
