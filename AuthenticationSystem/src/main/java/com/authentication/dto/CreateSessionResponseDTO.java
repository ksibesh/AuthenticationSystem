package com.authentication.dto;

public class CreateSessionResponseDTO extends BaseResponseDTO {

	private boolean sessionCreated;
	private String sessionId;

	public boolean isSessionCreated() {
		return sessionCreated;
	}

	public void setSessionCreated(boolean sessionCreated) {
		this.sessionCreated = sessionCreated;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "CreateSessionResponseDTO [sessionCreated=" + sessionCreated + ", sessionId=" + sessionId + ", " + super.toString() + "]";
	}

}
