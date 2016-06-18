package com.authentication.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

// TODO: find a way to configure the expiry time without changing the code
@Document(expiry = 60 * 20)
public class Session {

	private String token;
	private Map<String, Object> context;

	@Id
	@Field
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Field
	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Session [token=" + token + ", context=" + context + "]";
	}

}
