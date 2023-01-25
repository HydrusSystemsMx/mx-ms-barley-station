package com.icn.barleystation.controller;

import com.icn.barleystation.handler.ItemHandler;
import com.icn.barleystation.model.ItemResponse;
import com.icn.barleystation.model.RequestItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/barley/items")
public class ItemController {

    private final ItemHandler itemHandler;

    @PostMapping("/create")
    public void createNewItem(@RequestBody RequestItem request) {
        log.info("createNewItem()");
        itemHandler.createNewItem(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable("id") Long id) {
        log.info("getItemById()");
        return new ResponseEntity<>(itemHandler.getItemById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<ItemResponse> getItemByIdBrand(@RequestParam("idBrand") Long id) {
        return itemHandler.getItemByIdBrand(id);
    }

    @GetMapping("/all")
    public List<ItemResponse> getAllItems() {
        log.info("getAllItems()");
        return itemHandler.getAllItems();
    }

    @GetMapping("/allOut")
    public List<ItemResponse> getAll() {
        log.info("getAllItemss()");
        return itemHandler.getAll();
    }

}
