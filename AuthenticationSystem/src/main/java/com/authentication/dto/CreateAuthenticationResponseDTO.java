package com.authentication.dto;

public class CreateAuthenticationResponseDTO extends BaseResponseDTO {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CreateAuthenticationResponseDTO [username=" + username + "]";
	}

}
