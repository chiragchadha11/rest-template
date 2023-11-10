package com.example.githubuserresttemplate.repo;

import com.example.githubuserresttemplate.Entity.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<GitHubUser,Long> {
    @Query("SELECT u from GitHubUser u where u.login = :login")
    Optional<GitHubUser> getGitHubUserByLogin(@Param("login")String login);
}
