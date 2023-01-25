package com.icn.barleystation.service;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.dao.ItemDao;
import com.icn.barleystation.model.ItemDTO;
import com.icn.barleystation.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemDao itemDao;
    private final ItemRepository itemRepository;

    public void createNewItem(ItemDTO itemDTO) {
        log.info(CommonsHelper.START + "[createNewItem]");
        if (!itemDao.getItemByNameItem(itemDTO.getNameItem())) {
            itemRepository.createNewItem(itemDTO);
        }
        log.info(CommonsHelper.END + "[createNewItem]");
    }
}
