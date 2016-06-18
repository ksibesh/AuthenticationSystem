package com.authentication.dto;

public class ChangePasswordResponseDTO extends BaseResponseDTO {

	private boolean passwordChanged;

	public boolean isPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

	@Override
	public String toString() {
		return "ChangePasswordResponse [passwordChanged=" + passwordChanged + "]";
	}

}
