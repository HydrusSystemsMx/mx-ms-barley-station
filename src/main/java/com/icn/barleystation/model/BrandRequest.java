package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.Date;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String brandName;
	@Nullable
	private Boolean status;
	@Nullable
	private String image;
	private Date fechaCreacion;
	private Date ultimaModificacion;

}
