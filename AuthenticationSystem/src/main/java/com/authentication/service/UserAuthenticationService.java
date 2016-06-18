package com.authentication.service;

import com.authentication.dto.AuthenticationContextDTO;
import com.authentication.dto.AuthenticationRequestDTO;
import com.authentication.dto.BaseResponseDTO;
import com.authentication.exceptions.AuthenticationException;

public interface UserAuthenticationService {

	BaseResponseDTO createAuthUser(AuthenticationRequestDTO request);

	AuthenticationContextDTO authenticate(AuthenticationRequestDTO request) throws AuthenticationException;

}
