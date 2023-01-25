package com.icn.barleystation.handler;

import com.icn.barleystation.dao.BrandDao;
import com.icn.barleystation.dao.ItemDao;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.mapper.adapter.ItemModelMapper;
import com.icn.barleystation.model.BrandDTO;
import com.icn.barleystation.model.ItemDTO;
import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;
import com.icn.barleystation.service.IInventoryService;
import com.icn.barleystation.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemHandler {
    private final ItemService itemService;
    private final ItemDao itemDao;
    private final IInventoryService inventoryService;
    private final ItemModelMapper itemModelMapper;
    private final BrandDao brandDao;

    public void createNewItem(RequestItem requestItem) {
        BrandDTO brandDTO = brandDao.getBrandById(requestItem.getIdBrand());
        ItemDTO itemDTO = itemModelMapper.requestToItemDto(requestItem);
        itemDTO.setBrand(brandDTO);
        itemService.createNewItem(itemDTO);
    }

    public ItemResponse getItemById(Long id) {
        return itemDao.getItemById(id);
    }

    public List<ItemResponse> getItemByIdBrand(Long idBrand) {
        log.info("getItemByIdBrand()");
        List<InventoryEntity> itemsInInventory = inventoryService.getAllFromInventory();

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(idBrand);
        return itemDao.getItemByIdBrand(brandEntity, itemsInInventory);
    }

    public List<ItemResponse> getAllItems() {
        List<InventoryEntity> itemsInInventory = inventoryService.getAllFromInventory();
        return itemDao.getAllItems(itemsInInventory);
    }

    public List<ItemResponse> getAll() {
        return itemDao.getAll();
    }
}
