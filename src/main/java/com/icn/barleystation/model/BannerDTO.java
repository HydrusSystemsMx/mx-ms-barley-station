package com.icn.barleystation.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO {

	private Integer id;
	private String fechaCreacion;
	private String ultimaModificacion;
	private String url;
	@Nullable
	private Boolean status;

}
