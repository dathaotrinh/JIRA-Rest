package com.admin.jira.request;

import com.admin.jira.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
	private Comment comment;
}
