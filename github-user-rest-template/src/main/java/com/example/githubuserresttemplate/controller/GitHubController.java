package com.example.githubuserresttemplate.controller;

import com.example.githubuserresttemplate.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GitHubController {
    @Autowired
    GitHubUserService gitHubUserService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName){
        ResponseEntity<?> user = gitHubUserService.getUser(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
