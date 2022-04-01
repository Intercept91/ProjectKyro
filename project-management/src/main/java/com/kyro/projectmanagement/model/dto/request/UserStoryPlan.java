package com.kyro.projectmanagement.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserStoryPlan {
	
	@JsonProperty(value="projectId")
	private Long projectId;
	@JsonProperty(value="title")
	private String title;
	@JsonProperty(value="description")
	private String description;
	
}
