package com.authentication.dto;

public class AuthenticationContextDTO {

	// This flag is true if user profile profile is not setup
	private boolean updateProfile;

	private String username;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private Long userId;

	public boolean isUpdateProfile() {
		return updateProfile;
	}

	public void setUpdateProfile(boolean updateProfile) {
		this.updateProfile = updateProfile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuthenticationContextDTO [updateProfile=" + updateProfile + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + ", userId=" + userId + "]";
	}

}
