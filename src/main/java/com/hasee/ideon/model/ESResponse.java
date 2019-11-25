package com.hasee.ideon.model;
/**
 * Copyright (c) 2019. hasumaWebApplications - All Rights Reserved
 * Created by Hasitha Amarathunga on 11/23/2019.
 */
public class ESResponse<T>
{
	private int status;
	private T body;
	private String message;

	public ESResponse( int status, String message )
	{
		this.status = status;
		this.message = message;
	}

	public ESResponse( int status, T body, String message )
	{
		this.status = status;
		this.body = body;
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

	public T getBody()
	{
		return body;
	}

	public void setBody( T body )
	{
		this.body = body;
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
