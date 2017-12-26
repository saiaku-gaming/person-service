package com.valhallagame.personserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.personserviceclient.message.TokenParameter;
import com.valhallagame.personserviceclient.message.UsernameParameter;
import com.valhallagame.personserviceclient.message.UsernamePasswordParameter;
import com.valhallagame.personserviceclient.model.PersonData;
import com.valhallagame.personserviceclient.model.SessionData;

public class PersonServiceClient {
	private static PersonServiceClient personServiceClient;

	private String personServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.PERSON_SERVICE_PORT;
	private RestCaller restCaller;

	private PersonServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String personServiceServerUrl) {
		PersonServiceClient client = get();
		client.personServiceServerUrl = personServiceServerUrl;
	}

	public static PersonServiceClient get() {
		if (personServiceClient == null) {
			personServiceClient = new PersonServiceClient();
		}

		return personServiceClient;
	}

	public RestResponse<PersonData> getPerson(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/get-person", new UsernameParameter(username),
				PersonData.class);
	}

	public RestResponse<SessionData> signup(String username, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/signup",
				new UsernamePasswordParameter(username, password), SessionData.class);
	}

	public RestResponse<SessionData> login(String username, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/login",
				new UsernamePasswordParameter(username, password), SessionData.class);
	}

	public RestResponse<String> logout(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/logout", new UsernameParameter(username),
				String.class);
	}

	public RestResponse<String> checkLogin(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/check-login", new UsernameParameter(username),
				String.class);
	}

	public RestResponse<String> isUsernameAvailable(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/username-available",
				new UsernameParameter(username), String.class);
	}

	public RestResponse<SessionData> getSessionFromToken(String token) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/get-session-from-token",
				new TokenParameter(token), SessionData.class);
	}

	public RestResponse<SessionData> createDebugPerson(String token) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/create-debug-person", new TokenParameter(token),
				SessionData.class);
	}

	public RestResponse<String> validateCredentials(String username, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/validate-credentials",
				new UsernamePasswordParameter(username, password), String.class);
	}

	public RestResponse<String> heartbeat(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/heartbeat", new UsernameParameter(username),
				String.class);
	}

	public RestResponse<List<PersonData>> onlinePersons() throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/online-persons", null,
				new TypeReference<List<PersonData>>() {
				});
	}
}
