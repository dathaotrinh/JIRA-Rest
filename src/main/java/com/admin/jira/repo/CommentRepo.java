package com.admin.jira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.admin.jira.entity.Comment;

@CrossOrigin("https://angular-jira-clone.herokuapp.com/")
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
