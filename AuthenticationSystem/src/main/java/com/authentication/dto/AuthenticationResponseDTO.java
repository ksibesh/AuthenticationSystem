package com.authentication.dto;

public class AuthenticationResponseDTO extends CreateSessionResponseDTO {

	private boolean authenticated;
	private String sessionId;
	private AuthenticationContextDTO context;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public AuthenticationContextDTO getContext() {
		return context;
	}

	public void setContext(AuthenticationContextDTO context) {
		this.context = context;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "AuthenticationResponseDTO [authenticated=" + authenticated + ", sessionId=" + sessionId + ", context=" + context + "]";
	}

}
