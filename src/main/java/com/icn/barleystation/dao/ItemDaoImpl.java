package com.icn.barleystation.dao;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.mapper.adapter.ItemModelMapper;
import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.errors.BarleyException;
import com.icn.barleystation.repository.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemDaoImpl implements ItemDao {

    private final ItemJpaRepository itemJpaRepository;
    private final ItemModelMapper itemModelMapper;

    @Override
    public boolean getItemByNameItem(String nameItem) {
        return Objects.nonNull(itemJpaRepository.findByNameItem(nameItem));
    }

    @Override
    public ItemResponse getItemById(Long id) {
        return itemJpaRepository.findById(id).map(itemModelMapper::itemEntityToResponse).orElseThrow(() -> new BarleyException(CommonsHelper.ENTITY_NOT_FOUND_MSG, CommonsHelper.ENTITY_NOT_FOUND_CODE));

    }

    @Override
    public List<ItemResponse> getAllItems(List<InventoryEntity> itemsInInventory) {
        List<ItemResponse> response = new ArrayList<>();
        List<Long> idItemsInv = new ArrayList<>();

        for (InventoryEntity i : itemsInInventory) {
            idItemsInv.add(i.getItem().getId());
        }

        try {
            List<ItemEntity> allItems = itemJpaRepository.findAllById(idItemsInv);

            for (ItemEntity list : allItems) {
                for (InventoryEntity i : itemsInInventory) {
                    if (list.getId().equals(i.getItem().getId()) && i.getStack() > 0) {
                        ItemResponse itemResponse = itemModelMapper.itemEntityToResponse(i.getItem());
                        itemResponse.setStack(i.getStack());
                        response.add(itemResponse);
                    }

                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return response;
    }

    @Override
    public List<ItemResponse> getItemByIdBrand(BrandEntity brand, List<InventoryEntity> itemsInInventory) {
        List<ItemResponse> response = new ArrayList<>();

        try {
            List<ItemEntity> allItems = itemJpaRepository.findByBrand(brand);

            for (int i = 0; i < itemsInInventory.size(); i++) {
                for (int j = 0; j < allItems.size(); j++) {
                    if (itemsInInventory.get(i).getItem().getId().equals(allItems.get(j).getId())
                            && itemsInInventory.get(i).getStack() > 0) {
                        ItemResponse itemResponse = itemModelMapper.itemEntityToResponse(itemsInInventory.get(i).getItem());
                        itemResponse.setStack(itemsInInventory.get(i).getStack());
                        response.add(itemResponse);
                    }

                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return response;

    }

    @Override
    public List<ItemResponse> getAll() {
        List<ItemResponse> itemResponses = new ArrayList<>();
        List<ItemEntity> jpa = itemJpaRepository.findAll();
        for (ItemEntity resutls : jpa) itemResponses.add(itemModelMapper.itemEntityToResponse(resutls));
        return itemResponses;
    }
}
