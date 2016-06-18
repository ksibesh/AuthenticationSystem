package com.authentication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.constants.ResponseCodeConstants;
import com.authentication.constants.ResponseCodeConstants.ResponseCodeType;
import com.authentication.dto.AuthenticationContextDTO;
import com.authentication.dto.AuthenticationRequestDTO;
import com.authentication.dto.AuthenticationResponseDTO;
import com.authentication.dto.BaseResponseDTO;
import com.authentication.dto.ChangePasswordRequestDTO;
import com.authentication.dto.ChangePasswordResponseDTO;
import com.authentication.dto.CreateAuthenticationResponseDTO;
import com.authentication.dto.ResetPasswordRequestDTO;
import com.authentication.dto.ResetPasswordResponseDTO;
import com.authentication.exceptions.AuthenticationException;
import com.authentication.exceptions.AuthenticationException.AuthenticationExceptionCode;
import com.authentication.service.SessionService;
import com.authentication.service.UserAuthenticationService;
import com.authentication.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private UserAuthenticationService userAuthService;
	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public CreateAuthenticationResponseDTO getAuthByUsername(@RequestParam String username) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public BaseResponseDTO createUserAuth(@RequestBody AuthenticationRequestDTO request) {
		return userAuthService.createAuthUser(request);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthenticationResponseDTO authenticate(@RequestParam(required = false) boolean createSession, @RequestBody AuthenticationRequestDTO request) {
		AuthenticationContextDTO context = null;
		AuthenticationResponseDTO response = new AuthenticationResponseDTO();
		try {
			context = userAuthService.authenticate(request);

			CommonUtils.generateSuccessfulResponse(response);
			if (context == null) {
				response.setAuthenticated(false);
			} else {
				response.setAuthenticated(true);
				if (createSession) {
					ObjectMapper mapper = new ObjectMapper();
					@SuppressWarnings("unchecked")
					Map<String, Object> sessionContext = mapper.convertValue(context, HashMap.class);

					String sessionId = sessionService.createSession(sessionContext);
					response.setSessionId(sessionId);
					response.setContext(context);
				}
			}
		} catch (AuthenticationException e) {
			if (e.isExceptionCode(AuthenticationExceptionCode.ACC_NOT_FOUND)) {
				CommonUtils.generateResponse(response, ResponseCodeConstants.userNotFound, ResponseCodeType.DATA_ERROR);
			} else {
				CommonUtils.generateResponse(response, ResponseCodeConstants.passNotMatched, ResponseCodeType.DATA_ERROR);
			}
		}
		return response;
	}

	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public ChangePasswordResponseDTO changePassword(@RequestBody ChangePasswordRequestDTO request) {
		return null;
	}

	@RequestMapping(value = "/reset/password", method = RequestMethod.POST)
	public ResetPasswordResponseDTO resetPassword(@RequestBody ResetPasswordRequestDTO request) {
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public void logout() {

	}
}
