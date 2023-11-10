package com.example.githubuserresttemplate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHubUserDto {
    private Long id;
    private String login;
    private String node_id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String company;
    @JsonProperty("public_repos")
    private Integer publicRepos;
}
