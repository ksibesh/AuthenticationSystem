package com.authentication.service;

import java.util.Map;

public interface SessionService {

	String createSession(Map<String, Object> sessionContext);

}
