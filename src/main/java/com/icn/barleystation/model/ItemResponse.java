package com.icn.barleystation.model;

import com.icn.barleystation.model.errors.ErrorTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private Long id;
    private List<ErrorTO> errors;
    private String nameItem;
    private Double price;
    private String image;
    private String details;
    private boolean status;
    private Date createDate;
    private Date updateDate;
    private BrandDTO brand;
    private Integer stack;
}
