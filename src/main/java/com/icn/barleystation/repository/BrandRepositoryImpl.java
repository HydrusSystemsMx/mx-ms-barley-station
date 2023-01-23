package com.icn.barleystation.repository;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.commons.ErrorHandler;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.mapper.adapter.BrandAdapterMapper;
import com.icn.barleystation.model.BrandDTO;
import com.icn.barleystation.model.BrandResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    @Autowired
    private IBrandJpaRepository brandRepo;
    @Autowired
    private BrandAdapterMapper brandAdapterMapper;

    @Override
    public BrandResponse createNewBrand(BrandDTO brandDTO) {
        log.info(CommonsHelper.START + "[createNewBrand]");
        BrandResponse response = new BrandResponse();
        try {
            BrandEntity brandEntity = brandAdapterMapper.toEntity(brandDTO);
            brandEntity.setStatus(true);
            brandRepo.save(brandEntity);
        } catch (Exception e) {
            response.setErrors(ErrorHandler.retrieveErrors(e));
        }
        log.info(CommonsHelper.END + "[createNewBrand]");
        return response;
    }

}
