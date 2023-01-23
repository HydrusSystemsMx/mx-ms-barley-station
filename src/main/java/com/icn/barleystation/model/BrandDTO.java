package com.icn.barleystation.model;

import com.icn.barleystation.model.errors.ErrorTO;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
 	private Integer id;
	private String brandName;
	@Nullable
	private boolean status;
	@Nullable
	private String image;
	private Date createDate;
	private Date updateDate;
	private List<ErrorTO> errors;

}
