package com.icn.barleystation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestItem {
    private Integer id;
    private String nameItem;
    private Double price;
    private String image;
    private String details;
    private boolean status;
    private Date createDate;
    private Date updateDate;
    private Long idBrand;

}
