package com.icn.barleystation.repository;

import com.icn.barleystation.model.ItemDTO;

public interface ItemRepository {
    void createNewItem(ItemDTO itemDTO);
}
