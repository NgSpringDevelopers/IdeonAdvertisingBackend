package com.hasee.ideon.model;

import javax.persistence.*;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */
@Entity
@Table(name = "IDN_USER")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;

	@Column(name = "USERNAME", nullable = false)
	String username;

	@Column(name = "FULL_NAME", nullable = false)
	String fullName;

	@Column(name = "ADDRESS", nullable = false)
	String address;

	@Column(name = "EMAIL", nullable = false)
	String email;

	@Column(name = "MOBILE_NO", nullable = false)
	String mobile;

	@Column(name = "PASSWORD", nullable = false)
	String password;

	@Column(name = "LOGIN_TOKEN")
	String token;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName( String fullName )
	{
		this.fullName = fullName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile( String mobile )
	{
		this.mobile = mobile;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken( String token )
	{
		this.token = token;
	}
}
