package com.blogging.exception;

@SuppressWarnings("serial")
public class DuplicateBlogTitleException extends RuntimeException 
{
    public DuplicateBlogTitleException(String message) 
    {
        super(message);
    }
}