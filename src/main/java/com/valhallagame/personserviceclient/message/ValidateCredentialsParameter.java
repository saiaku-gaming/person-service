package com.valhallagame.personserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCredentialsParameter {
	@NotNull
	private String displayUsername;
	
	@NotNull
	private String password;
}
