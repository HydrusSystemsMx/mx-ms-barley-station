package com.icn.barleystation.dao;

import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.model.ItemResponse;

import java.util.List;

public interface ItemDao {
    boolean getItemByNameItem(String nameItem);

    ItemResponse getItemById(Long id);

    List<ItemResponse> getItemByIdBrand(BrandEntity id, List<InventoryEntity> itemsInInventory);

    List<ItemResponse> getAllItems(List<InventoryEntity> itemsInInventory);

    List<ItemResponse> getAll();
}
