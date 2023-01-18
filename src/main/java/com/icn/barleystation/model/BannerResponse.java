package com.icn.barleystation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BannerResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String fechaCreacion;
	private String ultimaModificacion;
	private String url;
	@Nullable
	private Boolean status;
	private List<ErrorTO> errors;

}
