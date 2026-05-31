package com.blogging.exception;

@SuppressWarnings("serial")
public class BlogNotFoundException extends RuntimeException
{
	public BlogNotFoundException(String message)
	{
		super(message);
	}
}
