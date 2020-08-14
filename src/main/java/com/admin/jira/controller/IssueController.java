package com.admin.jira.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.jira.entity.Issue;
import com.admin.jira.repo.IssueRepo;
import com.admin.jira.request.IssueRequest;

@RequestMapping("/api")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IssueController {


	@Autowired
	private IssueRepo issueRepo;
	
	
	@GetMapping("/issues/get")
	public List<Issue> getIssues() {
		return issueRepo.findAll();
	}
	
	

	@GetMapping("/issues/get/{id}")
	public Issue getUser(@PathVariable int id) {
		Optional<Issue> issue = issueRepo.findById(id);

		if (!issue.isPresent())
			return null;
			
		return issue.get();	
	}
	
	@PostMapping("/issues/create")
	public Issue saveIssue(@RequestBody Issue issue) {
		return issueRepo.save(issue);
	}
	

	@PutMapping("/issues/update/{id}")
	public ResponseEntity<Object> updateIssue(@RequestBody Issue issue, @PathVariable int id) {
		Optional<Issue> issueOptional = issueRepo.findById(id);

		if (!issueOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		issue.setTitle(issue.getTitle());
		issue.setDescription(issue.getDescription());
		issue.setEstimate(issue.getEstimate());
		issue.setIssuePriority(issue.getIssuePriority());
		issue.setIssueStatus(issue.getIssueStatus());
		issue.setIssueType(issue.getIssueType());
		issue.setProjectid(issue.getProjectid());
		issue.setReporterid(issue.getProjectid());
		issue.setTimeRemaining(issue.getTimeRemaining());
		issue.setTimeSpent(issue.getTimeSpent());
		
		issueRepo.save(issue);

		return ResponseEntity.noContent().build();
		

	}

	@DeleteMapping("/issues/delete/{id}")
	public void deleteIssue(@PathVariable int id) {
		issueRepo.deleteById(id);
	}
}
