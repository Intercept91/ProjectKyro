package com.kyro.projectmanagement.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectPlan {

	@JsonProperty(value="projectName")
	private String projectName;
	
	@JsonProperty(value="startDate")
	private String startDate;
	
	@JsonProperty(value="description") 
	private String description;
	 
}
