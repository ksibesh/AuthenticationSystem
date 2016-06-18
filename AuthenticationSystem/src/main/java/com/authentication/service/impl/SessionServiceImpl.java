package com.authentication.service.impl;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.entity.Session;
import com.authentication.repository.SessionRepository;
import com.authentication.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public String createSession(Map<String, Object> sessionContext) {
		String uniqueSessionId = generateUniqueSessionId();

		Session session = new Session();
		session.setToken(uniqueSessionId);
		session.setContext(sessionContext);

		sessionRepository.save(session);
		return uniqueSessionId;
	}

	private String generateUniqueSessionId() {
		return UUID.randomUUID().toString();
	}

	public Map<String, Object> getSessionContext(String sessionId) {
		Session session = sessionRepository.findOne(sessionId);
		return session.getContext();
	}

	public void updateSession(String sessionId, Map<String, Object> sessionContext) {
		Session session = sessionRepository.findOne(sessionId);
		session.setContext(sessionContext);

		sessionRepository.save(session);
	}

	public void partialUpdateSession(String sessionId, Map<String, Object> sessionContext) {
		Session session = sessionRepository.findOne(sessionId);
		session.getContext().putAll(sessionContext);

		sessionRepository.save(session);
	}
}
