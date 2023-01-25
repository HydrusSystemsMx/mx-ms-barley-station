package com.icn.barleystation.repository;

import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.mapper.adapter.ItemAdapterMapper;
import com.icn.barleystation.model.ItemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemAdapterMapper itemAdapterMapper;
    private final ItemJpaRepository itemJpaRepository;

    @Override
    public void createNewItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = itemAdapterMapper.toEntity(itemDTO);
        itemJpaRepository.save(itemEntity);
    }


}
