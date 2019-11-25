package com.hasee.ideon.model;

import javax.persistence.*;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/24/2019.
 */
@Entity
@Table(name = "IDN_CATEGORY")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;

	@Column(name = "CODE", nullable = false)
	String code;

	@Column(name = "NAME", nullable = false)
	String name;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode( String code )
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}
