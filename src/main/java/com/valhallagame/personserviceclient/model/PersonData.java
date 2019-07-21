package com.valhallagame.personserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonData {
	private String username;
	private String displayUsername;
	private boolean online;
	private String clientVersion;
    private boolean finishedTutorial;
}
