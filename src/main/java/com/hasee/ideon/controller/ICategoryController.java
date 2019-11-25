package com.hasee.ideon.controller;

import com.hasee.ideon.model.Category;
import com.hasee.ideon.model.ESResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */
@RequestMapping("category")
@CrossOrigin(origins = {"*"})
public interface ICategoryController
{
	@PostMapping(path = "/v{version}", produces = "application/json")
	ResponseEntity<ESResponse> registerCategory(@PathVariable String version, @RequestBody Category category );

	@GetMapping(path = "/v{version}", produces = "application/json")
	ResponseEntity<ESResponse> getCategories(@PathVariable String version);

	@PutMapping(path = "/v{version}/{id}", produces = "application/json")
	ResponseEntity<ESResponse> updateCategory(@PathVariable String version, @PathVariable long id, @RequestBody Category category );

	@DeleteMapping(path = "/v{version}/{id}", produces = "application/json")
	ResponseEntity<ESResponse> deleteCategory(@PathVariable String version, @PathVariable long id);

}
