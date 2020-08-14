package com.admin.jira.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String issueType; 		// task, issue, epic, story
	private String issueStatus;		// backlog, selected, inprocess, done
	private String issuePriority;	// highest, high, medium, low, lowest
	private String description;
	private int estimate;
	private int timeSpent;
	private int timeRemaining;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	private int reporterid;
	
	private int projectid;
	
}
