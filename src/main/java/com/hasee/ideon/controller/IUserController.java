package com.hasee.ideon.controller;

import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */

@RequestMapping("user")
@CrossOrigin(origins = { "*" })
public interface IUserController
{
	@PostMapping(path = "/v{version}", produces = "application/json")
	ResponseEntity<ESResponse> registerUser( @PathVariable String version, @RequestBody User counter );

	@GetMapping(path = "/v{version}/{username}", produces = "application/json")
	ResponseEntity<ESResponse> getUserByUsername( @PathVariable String version, @PathVariable String username);
}
