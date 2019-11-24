package com.hasee.ideon.service;

import com.hasee.ideon.constance.IConstants;
import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.model.User;
import com.hasee.ideon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */

@Service
public class UserService implements IUserService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	Environment environment;

	@Override
	public ESResponse registerUser( User user )
	{
		try {
			User user1 = userRepository.findByUsername( user.getUsername() );
			if (user1 != null) {
				return new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.username.already.taken" ) );
			}
			User user2 = userRepository.findByEmail( user.getEmail() );
			if (user2 != null) {
				return new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.email.already.taken" ) );
			}
			User user3 = userRepository.findByMobile( user.getMobile() );
			if (user3 != null) {
				return new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.mobile.already.taken" ) );
			}
			User user4 = userRepository.save( user );
			return  new ESResponse<>( IConstants.RESPONSE_STATUS_OK, user4, environment.getProperty( "user.create.success" ) );
		} catch ( Exception e ) {
			return new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.email.missing" ) );
		}
	}

	@Override
	public ESResponse getUserByUsername( String username )
	{
		User user = userRepository.findByUsername( username );
		if (user == null) {
			return new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "user.not.found" ) );
		}
		return new ESResponse<>( IConstants.RESPONSE_STATUS_OK , user , environment.getProperty( "user.found" ));
	}
}
