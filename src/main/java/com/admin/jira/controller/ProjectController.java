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

import com.admin.jira.entity.Project;
import com.admin.jira.repo.ProjectRepo;
import com.admin.jira.request.ProjectRequest;

@RequestMapping("/api")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

	@Autowired
	private ProjectRepo projectRepo;


	@GetMapping("/projects/get")
	public List<Project> getProjects() {
		return projectRepo.findAll();
	}
	
	@GetMapping("/projects/get/{id}")
	public Project getProject(@PathVariable int id) {
		Optional<Project> project = projectRepo.findById(id);

		if (!project.isPresent())
			return null;
			
		return project.get();	
	}
	

	@PostMapping("/projects/create")
	public Project saveProject(@RequestBody Project project) {
		return projectRepo.save(project);
	}
	


	@PutMapping("/projects/update/{id}")
	public ResponseEntity<Object> updateProject(@RequestBody Project project, @PathVariable int id) {
		Optional<Project> projectOptional = projectRepo.findById(id);

		if (!projectOptional.isPresent())
			return ResponseEntity.notFound().build();

		project.setCategory(project.getCategory());
		project.setCreatedAt(project.getCreatedAt());
		project.setDescription(project.getDescription());
		project.setName(project.getName());
		project.setUrl(project.getUrl());
		project.setName(project.getName());
		
		projectRepo.save(project);

		return ResponseEntity.noContent().build();	

	}
	
	@DeleteMapping("/projects/delete/{id}")
	public void deleteProject(@PathVariable int id) {
		projectRepo.deleteById(id);
	}
	
	
}
