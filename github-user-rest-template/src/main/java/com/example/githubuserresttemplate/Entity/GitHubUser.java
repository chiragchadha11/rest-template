package com.example.githubuserresttemplate.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GitHubUser {
    @Id
    private Long id;
    @Column(unique = true)
    private String login;
    private String node_id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String company;
    @JsonProperty("public_repos")
    private Integer publicRepos;

}
