package com.valhallagame.personserviceclient.message;

import javax.validation.constraints.NotNull;

import com.valhallagame.common.AllwaysExposedInYmer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPersonParameter {
	@NotNull
	@AllwaysExposedInYmer
	private String username;
}
