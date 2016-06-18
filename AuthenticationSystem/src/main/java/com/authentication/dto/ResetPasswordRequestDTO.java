package com.authentication.dto;

public class ResetPasswordRequestDTO {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ResetPasswordRequestDTO [username=" + username + "]";
	}

}
