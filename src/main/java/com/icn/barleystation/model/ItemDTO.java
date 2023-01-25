package com.icn.barleystation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String nameItem;
    private Double price;
    private String image;
    private String details;
    private boolean status;
    private Date createDate;
    private Date updateDate;
    private BrandDTO brand;

}
