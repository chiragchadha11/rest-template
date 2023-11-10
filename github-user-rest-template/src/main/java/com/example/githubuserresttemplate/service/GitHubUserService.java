package com.example.githubuserresttemplate.service;

import com.example.githubuserresttemplate.Entity.GitHubUser;
import com.example.githubuserresttemplate.dto.GitHubUserDto;
import org.springframework.http.ResponseEntity;


public interface GitHubUserService {

    public ResponseEntity<?> getUser(String UserName);
    public GitHubUser dtoToUser(GitHubUserDto gitHubUserDto);
    public GitHubUserDto userToDto(GitHubUser gitHubUser);
}
