package com.kyro.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyro.projectmanagement.model.Project;
import com.kyro.projectmanagement.model.Task;
import com.kyro.projectmanagement.model.UserStory;
import com.kyro.projectmanagement.repository.ProjectRepository;
import com.kyro.projectmanagement.repository.TaskRepository;
import com.kyro.projectmanagement.repository.UserStoryRepository;

//This Service is used for Updating the ProjectDetails provided by ProjectManagment Team.
@Service
public class ProjectInputService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserStoryRepository userStoryRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public List<Project> uploadProjectDetails(List<Project> projects)
	{
		return projects != null ? projectRepository.saveAll(projects) : null;
	}
	
	public List<UserStory> uploadUserStoryDetails(List<UserStory> stories)
	{
		return stories != null ? userStoryRepository.saveAll(stories) : null;
	}
	
	public List<Task> uploadTaskDetails(List<Task> task)
	{
		return task != null ? taskRepository.saveAll(task) : null;
	}
	
}
