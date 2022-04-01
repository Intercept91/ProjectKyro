package com.kyro.projectmanagement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyro.projectmanagement.controller.transformer.ProjectTransformer;
import com.kyro.projectmanagement.controller.transformer.TaskTransformer;
import com.kyro.projectmanagement.controller.transformer.UserStoryTransformer;
import com.kyro.projectmanagement.model.Project;
import com.kyro.projectmanagement.model.Task;
import com.kyro.projectmanagement.model.UserStory;
import com.kyro.projectmanagement.model.dto.request.ProjectPlan;
import com.kyro.projectmanagement.model.dto.request.TaskPlan;
import com.kyro.projectmanagement.model.dto.request.UserStoryPlan;
import com.kyro.projectmanagement.model.dto.response.ProjectETAResponse;
import com.kyro.projectmanagement.service.ProjectDetailsProviderService;
import com.kyro.projectmanagement.service.ProjectInputService;

@RestController
@RequestMapping("/kyro/project/")
public class ProjectController {

	@Autowired
	private ProjectInputService projectInputService;
	
	@Autowired
	private ProjectDetailsProviderService projectDetailsProviderService;

	@PostMapping(value ="/createProject")
	public ResponseEntity<?> uploadProjectDetailsFromJson(@RequestBody ProjectPlan projectPlan) {
		
		ProjectTransformer transformer = new ProjectTransformer();
		List<Project> saved = projectInputService.uploadProjectDetails(transformer.apply(projectPlan));
		return getStatus(saved);
	}

	@PostMapping(value ="{projectId}/createUserStory")
	public ResponseEntity<?> uploadUserStoriesFromJson(@RequestBody List<UserStoryPlan> storyPlan) {
		
		UserStoryTransformer transformer = new UserStoryTransformer();
		List<UserStory> saved = projectInputService.uploadUserStoryDetails(transformer.apply(storyPlan));
		
		return getStatus(saved);
	}

	@PostMapping(value = "{userStoryId}/createTask")
	public ResponseEntity<?> uploadTaskFromJson(@RequestBody List<TaskPlan> taskPlan) {
		
		TaskTransformer transformer = new TaskTransformer();
		List<Task> saved = projectInputService.uploadTaskDetails(transformer.apply(taskPlan));
		
		return getStatus(saved);
	}
	
	@GetMapping(value = "{projectId}/calculateTotalHours")
	public ProjectETAResponse getTotalHoursRequiredForProject(@PathVariable("projectId") Long projectId)
	{
		return projectDetailsProviderService.calculateTotalDays(projectId);
	}
	
	public ResponseEntity<?> getStatus(List<?> saved) {
		return saved != null ? ResponseEntity.status(HttpStatus.CREATED).body(saved)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in storing data into DB");
	}

}
