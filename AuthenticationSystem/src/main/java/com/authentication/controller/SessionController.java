package com.authentication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.dto.CreateSessionResponseDTO;
import com.authentication.service.SessionService;
import com.authentication.utils.CommonUtils;

@RestController
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public void getAllActiveUserSessions(@RequestParam String username) {

	}

	@RequestMapping(value = "/{sessionId}", method = RequestMethod.GET)
	public void getSessionById(@PathVariable String sessionId) {

	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public CreateSessionResponseDTO createSession(@RequestBody Map<String, Object> sessionContext) {
		String sessionId = sessionService.createSession(sessionContext);

		CreateSessionResponseDTO response = new CreateSessionResponseDTO();
		CommonUtils.generateSuccessfulResponse(response);
		response.setSessionCreated(true);
		response.setSessionId(sessionId);

		return response;
	}

	@RequestMapping(value = "/{sessionId}", method = RequestMethod.POST)
	public void updateSession(@PathVariable String sessionId, @RequestBody Map<String, Object> sessionContext) {
	}

	@RequestMapping(value = "/{sessionId}", method = RequestMethod.PATCH)
	public void partialUpdateSession(@PathVariable String sessionId, @RequestBody Map<String, Object> sessionContext) {
	}
}
