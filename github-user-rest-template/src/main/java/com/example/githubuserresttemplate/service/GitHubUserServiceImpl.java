package com.example.githubuserresttemplate.service;

import com.example.githubuserresttemplate.Entity.GitHubUser;
import com.example.githubuserresttemplate.dto.GitHubUserDto;
import com.example.githubuserresttemplate.exception.UserNotFoundException;
import com.example.githubuserresttemplate.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class GitHubUserServiceImpl implements GitHubUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<?> getUser(String userName) {
        if (userName==null){
            throw new UserNotFoundException("User with User Name: " + userName + " not found");
        }
        Optional<GitHubUser> gitHubUserByLogin = userRepo.getGitHubUserByLogin(userName);
        if (gitHubUserByLogin.isEmpty()) {
            GitHubUserDto gitHubUserDto = restTemplate.getForObject("https://api.github.com/users/" + userName, GitHubUserDto.class);
            GitHubUser gitHubUser = dtoToUser(gitHubUserDto);
            if (gitHubUser!=null){
                return ResponseEntity.status(HttpStatus.OK).body(userRepo.save(gitHubUser));
            }


        }

        return ResponseEntity.status(HttpStatus.OK).body(userToDto(gitHubUserByLogin.get()));
    }

    @Override
    public GitHubUser dtoToUser(GitHubUserDto gitHubUserDto) {
        GitHubUser gitHubUser = modelMapper.map(gitHubUserDto,GitHubUser.class);
        return gitHubUser;
    }

    @Override
    public GitHubUserDto userToDto(GitHubUser gitHubUser) {
        GitHubUserDto gitHubUserDto = modelMapper.map(gitHubUser,GitHubUserDto.class);
        return gitHubUserDto;
    }
}
