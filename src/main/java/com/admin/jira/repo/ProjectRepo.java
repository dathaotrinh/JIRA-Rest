package com.admin.jira.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.admin.jira.entity.Issue;
import com.admin.jira.entity.Project;
import com.admin.jira.entity.User;

@CrossOrigin("http://localhost:4200")
public interface ProjectRepo extends JpaRepository<Project, Integer> {

	void save(User user);
	void save(Issue issue);

}
