package com.hasee.ideon.service;

import com.hasee.ideon.constance.IConstants;
import com.hasee.ideon.model.Category;
import com.hasee.ideon.model.ESResponse;
import com.hasee.ideon.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */
@Service
public class CategoryService implements ICategoryService
{
	@Autowired
	Environment environment;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public ESResponse registerCategory( Category category )
	{
		if(category.getCode() == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.code.missing" ) );
		}
		if(category.getName() == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.name.missing" ) );
		}
		Category category1 = categoryRepository.findByCode( category.getCode() );
		if (category1 != null) {
			return  new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.code.already.taken" ) );
		}
		Category category2 = categoryRepository.save( category );
		return new ESResponse( IConstants.RESPONSE_STATUS_OK, category2, environment.getProperty( "category.save.success" ) );
	}

	@Override
	public ESResponse getAllCategories()
	{
		ArrayList<Category> categories = ( ArrayList<Category> ) categoryRepository.findAll();
		if ( categories.size() < 1 ) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.not.found" ) );
		}
		return new ESResponse( IConstants.RESPONSE_STATUS_OK, categories, environment.getProperty( "category.found" ) );
	}

	@Override
	public ESResponse editCategory( Long id, Category category )
	{
		if(category.getCode() == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.code.missing" ) );
		}
		if(category.getName() == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.name.missing" ) );
		}
		Category category2 = categoryRepository.findById( id ) .orElse( null );
		if (category2 == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.not.found" ) );
		}
		Category category3 = categoryRepository.save(category);
		return new ESResponse( IConstants.RESPONSE_STATUS_OK, category3, environment.getProperty( "category.edit.success" ) );
	}

	@Override
	public ESResponse deleteCategory( Long id )
	{
		Category category = categoryRepository.findById( id ) .orElse( null );
		if (category == null) {
			return new ESResponse( IConstants.RESPONSE_STATUS_ERROR, environment.getProperty( "category.not.found" ) );
		}
		categoryRepository.delete( category );
		return new ESResponse( IConstants.RESPONSE_STATUS_OK, environment.getProperty( "category.delete.success" ) );
	}
}
