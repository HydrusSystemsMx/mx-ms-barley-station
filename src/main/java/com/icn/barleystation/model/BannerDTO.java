package com.icn.barleystation.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO {

	private Long id;
	private Date fechaCreacion;
	private Date ultimaModificacion;
	private String url;
	@Nullable
	private boolean status;

}
