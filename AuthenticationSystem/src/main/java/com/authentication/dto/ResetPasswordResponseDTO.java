package com.authentication.dto;

public class ResetPasswordResponseDTO extends BaseResponseDTO {

	private boolean passwordReset;
	private String newPassword;

	public boolean isPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(boolean passwordReset) {
		this.passwordReset = passwordReset;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ResetPasswordResponseDTO [passwordReset=" + passwordReset + ", newPassword=" + newPassword + "]";
	}

}
