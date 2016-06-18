package com.authentication.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document(expiry = 0)
public class Authentication {

	public static enum AccountState {
		ACTIVE, INACTIVE
	}

	private String username;
	private String password;
	private boolean isRaw;
	private Long userId;
	private AccountState state = AccountState.ACTIVE;
	private String remark;
	private List<String> sessionList;

	@Id
	@Field
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Field
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Field("is_raw")
	public boolean isRaw() {
		return isRaw;
	}

	public void setRaw(boolean isRaw) {
		this.isRaw = isRaw;
	}

	@Field("user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Field
	public AccountState getState() {
		return state;
	}

	public void setState(AccountState state) {
		this.state = state;
	}

	@Field
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Field
	public List<String> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<String> sessionList) {
		this.sessionList = sessionList;
	}

	@Override
	public String toString() {
		return "Authentication [username=" + username + ", password=" + password + ", isRaw=" + isRaw + ", userId=" + userId + ", state=" + state + ", remark=" + remark
				+ ", sessionList=" + sessionList + "]";
	}

}
