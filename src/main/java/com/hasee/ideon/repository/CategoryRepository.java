package com.hasee.ideon.repository;

import com.hasee.ideon.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
	Category findByCode(String code);
}
