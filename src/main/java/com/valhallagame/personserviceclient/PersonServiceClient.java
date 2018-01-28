package com.valhallagame.personserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.personserviceclient.message.CheckLoginParameter;
import com.valhallagame.personserviceclient.message.CreateDebugPersonParameter;
import com.valhallagame.personserviceclient.message.GetPersonParameter;
import com.valhallagame.personserviceclient.message.GetSessionFromTokenParameter;
import com.valhallagame.personserviceclient.message.HeartbeatParameter;
import com.valhallagame.personserviceclient.message.LoginParameter;
import com.valhallagame.personserviceclient.message.LogoutParameter;
import com.valhallagame.personserviceclient.message.SignupParameter;
import com.valhallagame.personserviceclient.message.UsernameAvailableParameter;
import com.valhallagame.personserviceclient.message.ValidateCredentialsParameter;
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
		return restCaller.postCall(personServiceServerUrl + "/v1/person/get-person", new GetPersonParameter(username),
				PersonData.class);
	}

	public RestResponse<SessionData> signup(String displayUsername, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/signup",
				new SignupParameter(displayUsername, password), SessionData.class);
	}

	public RestResponse<SessionData> login(String displayUsername, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/login",
				new LoginParameter(displayUsername, password), SessionData.class);
	}

	public RestResponse<String> logout(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/logout", new LogoutParameter(username),
				String.class);
	}	

	public RestResponse<String> checkLogin(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/check-login", new CheckLoginParameter(username),
				String.class);
	}

	public RestResponse<String> usernameAvailable(String displayUsername) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/username-available",
				new UsernameAvailableParameter(displayUsername), String.class);
	}

	public RestResponse<SessionData> getSessionFromToken(String token) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/get-session-from-token",
				new GetSessionFromTokenParameter(token), SessionData.class);
	}

	public RestResponse<SessionData> createDebugPerson(String token) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/create-debug-person", new CreateDebugPersonParameter(token),
				SessionData.class);
	}

	public RestResponse<String> validateCredentials(String username, String password) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/validate-credentials",
				new ValidateCredentialsParameter(username, password), String.class);
	}

	public RestResponse<String> heartbeat(String username) throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/heartbeat", new HeartbeatParameter(username),
				String.class);
	}

	public RestResponse<List<PersonData>> onlinePersons() throws IOException {
		return restCaller.postCall(personServiceServerUrl + "/v1/person/online-persons", null,
				new TypeReference<List<PersonData>>() {
				});
	}
}
