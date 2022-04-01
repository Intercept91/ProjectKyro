package com.kyro.projectmanagement.model.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyro.projectmanagement.model.Resource;
import com.kyro.projectmanagement.model.Task;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskPlan {
	
	@JsonProperty(value="owner")
	private String owner;
	
	@JsonProperty(value="title")
	private String title;
	
	@JsonProperty(value="estimatedTime")
	private Integer estimatedTime;
	
	@JsonProperty(value="userStoryId")
	private Long userStoryId;
	
	@JsonProperty(value="resources")
	private List<Resource> resources;
	
	@JsonProperty(value="childTasks")
	private List<Task> childTasks;
}
