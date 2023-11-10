package com.example.githubuserresttemplate.aop;

import com.example.githubuserresttemplate.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GitHubUserExceptionHandler {
    @ExceptionHandler
    public String handleExceptionForGitHubUser(UserNotFoundException ex){
       return ex.getMessage();
    }
}
