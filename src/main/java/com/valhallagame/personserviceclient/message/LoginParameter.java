package com.valhallagame.personserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParameter {
	@NotBlank
	private String displayUsername;

	@NotBlank
	private String password;
}
