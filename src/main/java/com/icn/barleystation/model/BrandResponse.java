package com.icn.barleystation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.icn.barleystation.entity.BrandEntity;
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
	private List<ErrorTO> errors;
	private BrandEntity response;
}
