package com.hasee.ideon.repository;

import com.hasee.ideon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);
	User findByEmail(String email);
	User findByMobile(String mobile);
}
