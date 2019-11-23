package com.hasee.ideon.service;

import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.model.User;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */

public interface IUserService
{
	ESResponse registerUser(User user);
	ESResponse getUserByUsername(String username);
}
