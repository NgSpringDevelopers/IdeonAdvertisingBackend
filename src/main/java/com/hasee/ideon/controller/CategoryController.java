package com.hasee.ideon.controller;

import com.hasee.ideon.constance.IConstants;
import com.hasee.ideon.model.Category;
import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */
@RestController
public class CategoryController implements ICategoryController
{
	@Autowired
	Environment environment;

	@Autowired
	ICategoryService categoryService;

	@Override
	public ResponseEntity<ESResponse> registerCategory( String version, Category category )
	{
		if(version == null) {
			return ResponseEntity.badRequest().body(new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "version.missing" )));
		}
		return ResponseEntity.ok().body(categoryService.registerCategory(category));
	}

	@Override
	public ResponseEntity<ESResponse> getCategories( String version )
	{
		if(version == null) {
			return ResponseEntity.badRequest().body(new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "version.missing" )));
		}
		return ResponseEntity.ok().body( categoryService.getAllCategories() );
	}

	@Override
	public ResponseEntity<ESResponse> updateCategory( String version, long id, Category category )
	{
		if(version == null) {
			return ResponseEntity.badRequest().body(new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "version.missing" )));
		}
		if(id == 0) {
			return ResponseEntity.badRequest().body(new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "id.missing" )));
		}
		return ResponseEntity.ok().body( categoryService.editCategory( id, category ) );
	}

	@Override
	public ResponseEntity<ESResponse> deleteCategory( String version, long id )
	{
		if(version == null) {
			return ResponseEntity.badRequest().body(new ESResponse<>( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "version.missing" )));
		}
		return ResponseEntity.ok().body( categoryService.deleteCategory( id ) );
	}
}
