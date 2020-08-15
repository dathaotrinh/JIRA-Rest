package com.admin.jira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.admin.jira.entity.User;

@CrossOrigin("https://angular-jira-clone.herokuapp.com/")
public interface UserRepo extends JpaRepository<User, Integer> {

}
