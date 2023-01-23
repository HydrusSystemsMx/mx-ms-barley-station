package com.icn.barleystation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BannerResponse {

	private Long id;
	private String createDate;
	private String updateDate;
	private String url;
	@Nullable
	private boolean status;
	private List<ErrorTO> errors;

}
