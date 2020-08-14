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

import com.admin.jira.entity.Comment;
import com.admin.jira.repo.CommentRepo;
import com.admin.jira.request.CommentRequest;

@RequestMapping("/api")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

	@Autowired
	private CommentRepo commentRepo;
	
	
	@GetMapping("/comments/get")
	public List<Comment> getComments() {
		return commentRepo.findAll();
	}


	@GetMapping("/comments/get/{id}")
	public Comment getComment(@PathVariable int id) {
		Optional<Comment> comment = commentRepo.findById(id);

		if (!comment.isPresent())
			return null;
			
		return comment.get();	
	}
	
	@PostMapping("/comments/create")
	public Comment saveComment(@RequestBody Comment comment) {
		return commentRepo.save(comment);
	}
	

	@PutMapping("/comments/update/{id}")
	public ResponseEntity<Object> updateComment(@RequestBody Comment comment, @PathVariable int id) {
		Optional<Comment> commentOptional = commentRepo.findById(id);

		if (!commentOptional.isPresent())
			return ResponseEntity.notFound().build();

		comment.setBody(comment.getBody());
		comment.setCreatedAt(comment.getCreatedAt());
		comment.setIssueid(comment.getIssueid());
		comment.setProjectid(comment.getProjectid());
		
		commentRepo.save(comment);

		return ResponseEntity.noContent().build();
		

	}

	@DeleteMapping("/comments/delete/{id}")
	public void deleteComment(@PathVariable int id) {
		commentRepo.deleteById(id);
	}
}
