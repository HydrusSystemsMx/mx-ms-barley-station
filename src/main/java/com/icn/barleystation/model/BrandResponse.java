package com.icn.barleystation.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.icn.barleystation.model.errors.ErrorTO;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandResponse {
	private Long id;
	private String brandName;
	@Nullable
	private boolean status;
	@Nullable
	private String image;
	private Date createDate;
	private Date updateDate;
	private List<ErrorTO> errors;
}
