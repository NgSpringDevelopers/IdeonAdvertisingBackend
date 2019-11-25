package com.hasee.ideon.service;

import com.hasee.ideon.model.Category;
import com.hasee.ideon.model.ESResponse;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */
public interface ICategoryService
{
	ESResponse registerCategory( Category category );
	ESResponse getAllCategories();
	ESResponse editCategory(Long id, Category category);
	ESResponse deleteCategory(Long id);
}
