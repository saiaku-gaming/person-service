package com.valhallagame.personserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDebugPersonParameter {
	@NotNull
	private String token;

	private String singleton;
}
