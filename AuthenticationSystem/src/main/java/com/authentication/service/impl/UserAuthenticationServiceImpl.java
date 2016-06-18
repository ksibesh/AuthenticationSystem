package com.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.dto.AuthenticationContextDTO;
import com.authentication.dto.AuthenticationRequestDTO;
import com.authentication.dto.CreateAuthenticationResponseDTO;
import com.authentication.entity.Authentication;
import com.authentication.entity.User;
import com.authentication.exceptions.AuthenticationException;
import com.authentication.exceptions.AuthenticationException.AuthenticationExceptionCode;
import com.authentication.repository.AuthRepository;
import com.authentication.repository.UserRepository;
import com.authentication.service.UserAuthenticationService;
import com.authentication.utils.CommonUtils;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public CreateAuthenticationResponseDTO createAuthUser(AuthenticationRequestDTO request) {
		Authentication auth = new Authentication();
		auth.setUsername(request.getUsername());
		auth.setPassword(encryptPassword(request.getPassword()));
		auth.setRaw(false);

		authRepository.save(auth);
		CreateAuthenticationResponseDTO response = new CreateAuthenticationResponseDTO();
		CommonUtils.generateSuccessfulResponse(response);
		return response;
	}

	public CreateAuthenticationResponseDTO getAuthUserByUsername(String username) {
		Authentication auth = authRepository.findOne(username);
		if (auth == null) {

		}
		return null;
	}

	// TODO: write its defination
	private String encryptPassword(String password) {
		return password;
	}

	@Override
	public AuthenticationContextDTO authenticate(AuthenticationRequestDTO request) throws AuthenticationException {
		Authentication auth = authRepository.findOne(request.getUsername());
		if (auth == null) {
			throw new AuthenticationException(AuthenticationExceptionCode.ACC_NOT_FOUND);
		}
		String password = auth.isRaw() ? request.getPassword() : encryptPassword(request.getPassword());

		if (auth.getPassword().equals(password)) {
			AuthenticationContextDTO context = new AuthenticationContextDTO();
			context.setUsername(auth.getUsername());

			Long userId = auth.getUserId();
			if (userId != null) {
				User user = userRepository.findOne(userId);
				context.setFirstname(user.getFirstname());
				context.setLastname(user.getLastname());
				context.setPhoneNumber(user.getPhoneNumber());
				context.setUserId(user.getId());
			} else {
				context.setUpdateProfile(true);
			}
			return context;
		}
		return null;
	}

	public void updateAuthUser() {

	}
}
