package com.admin.jira.request;

import com.admin.jira.entity.Issue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequest {
	
	private Issue issue;
}
