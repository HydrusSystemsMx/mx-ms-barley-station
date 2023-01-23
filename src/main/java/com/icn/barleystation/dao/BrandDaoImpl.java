package com.icn.barleystation.dao;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.mapper.adapter.BrandModelMapper;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.model.errors.BarleyException;
import com.icn.barleystation.repository.IBrandJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Component
public class BrandDaoImpl implements BrandDao {
    @Autowired
    private IBrandJpaRepository brandRepo;
    @Autowired
    private final BrandModelMapper brandModelMapper;

    @Override
    public BrandResponse getBrandById(Long id) {
        return brandRepo.findById(id).map(brandModelMapper::brandEntityToResponse).orElseThrow(()-> new BarleyException(CommonsHelper.ENTITY_NOT_FOUND_MSG, CommonsHelper.ENTITY_NOT_FOUND_CODE));
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        return Optional.of(brandRepo.findAll()
                        .stream()
                        .map(brandModelMapper::brandEntityToResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean getBrandByBrandName(String brandName) {
        return Objects.nonNull(brandRepo.findByBrandName(brandName));
    }
}
