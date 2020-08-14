package com.admin.jira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.admin.jira.entity.User;

@CrossOrigin("http://localhost:4200")
public interface UserRepo extends JpaRepository<User, Integer> {

}
