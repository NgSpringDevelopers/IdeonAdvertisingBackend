package com.hasee.ideon.controller;

import com.hasee.ideon.constance.IConstants;
import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.model.User;
import com.hasee.ideon.service.IUserService;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */

@RestController
public class UserController implements IUserController
{
	@Autowired
	IUserService userService;

	@Autowired
	Environment environment;

	@Override
	public ResponseEntity<ESResponse> registerUser( String version, User user )
	{
		if (user.getUsername() == null) {
			return ResponseEntity.badRequest().body( new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.username.missing" ) ) );
		}
		if (user.getEmail() == null) {
			return ResponseEntity.badRequest().body( new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.email.missing" ) ) );
		}
		return ResponseEntity.ok().body( userService.registerUser( user ) );
	}

	@Override
	public ResponseEntity<ESResponse> getUserByUsername( String version, String username )
	{
		if (version == null) {
			return ResponseEntity.badRequest().body( new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "version.missing" ) ) );
		}

		if (username == null) {
			return ResponseEntity.badRequest().body( new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.username.missing" ) ) );
		}

		return ResponseEntity.ok().body( userService.getUserByUsername( username ));
	}
}
