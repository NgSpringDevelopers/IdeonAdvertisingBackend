package com.hasee.ideon.model;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */
public class ESResponse<T>
{
	private int status;
	private T data;
	private String message;

	public ESResponse( int status, String message )
	{
		this.status = status;
		this.message = message;
	}

	public ESResponse( int status, T data, String message )
	{
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public ESResponse()
	{
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}

	public T getData()
	{
		return data;
	}

	public void setData( T data )
	{
		this.data = data;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}
}
