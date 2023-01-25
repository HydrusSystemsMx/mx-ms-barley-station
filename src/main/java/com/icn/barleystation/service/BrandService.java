package com.icn.barleystation.service;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.dao.BrandDao;
import com.icn.barleystation.model.BrandDTO;
import com.icn.barleystation.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrandService  {
	private final BrandDao brandDao;
	private final BrandRepository brandRepository;

	public void createNewBrand(BrandDTO brandDTO) {
		log.info(CommonsHelper.START + "[createNewBrand]");
		if (!brandDao.getBrandByBrandName(brandDTO.getBrandName())) {
			brandRepository.createNewBrand(brandDTO);
		}
		log.info(CommonsHelper.END + "[createNewBrand]");
	}
}
