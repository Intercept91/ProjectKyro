package com.kyro.projectmanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyro.projectmanagement.model.Project;
import com.kyro.projectmanagement.model.Resource;
import com.kyro.projectmanagement.model.Task;
import com.kyro.projectmanagement.model.UserStory;
import com.kyro.projectmanagement.model.dto.response.ProjectETAResponse;
import com.kyro.projectmanagement.repository.ProjectRepository;
import com.kyro.projectmanagement.repository.TaskRepository;
import com.kyro.projectmanagement.repository.UserStoryRepository;
import com.kyro.projectmanagement.utils.DateUtils;

//This Service is retrieves the ProjectDetails.
@Service
public class ProjectDetailsProviderService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserStoryRepository userStoryRepository;

	@Autowired
	private TaskRepository taskRepository;

	public Project getProjectDetailsByProjectId(Long projectId) {
		return projectId != null ? projectRepository.getById(projectId) : null;
	}

	public List<UserStory> getUserStoryDetailsByProjectId(List<Long> stotyId) {
		return stotyId != null ? userStoryRepository.findAllById(stotyId) : null;
	}

	public List<Task> getTaskDetailsByProjectId(List<Long> taskId) {
		return taskId != null ? taskRepository.findAllById(taskId) : null;
	}

	public ProjectETAResponse calculateTotalDays(Long projectid) {

		Project project = getProjectDetailsByProjectId(projectid);
		Date projectStartDate = DateUtils.convertStringToDate(project.getProjectStartDate());

		List<String> ownerList = new ArrayList<>();
		List<UserStory> stories = userStoryRepository.findByProjectId(projectid);
		int duration = 0;
		for (UserStory us : stories) {
			List<Task> tasks = taskRepository.findByStoryId(us.getStoryId());
			for (Task t : tasks) {
				ownerList.add(t.getOwner());
				duration += t.getEstimatedTime();
				if (t.getChildTask() != null && t.getChildTask().size() > 0) {
					for (Task ct : t.getChildTask()) {
						ownerList.add(t.getOwner());
						duration += ct.getEstimatedTime();
					}
				}
				if (t.getResources() != null && t.getResources().size() > 0) {
					for (Resource ct : t.getResources()) {
						duration += ct.getHours();
					}
				}

			}
		}
		int teamSize = ownerList.size();
		// per day - 6 hrs of productivity is considered.
		Date projectEndDate = DateUtils.getTotalDays(duration / (teamSize * 6), projectStartDate);

		return createProjectETAResponse(project, projectEndDate);

	}

	private ProjectETAResponse createProjectETAResponse(Project project, Date projectEndDate) {
		ProjectETAResponse response = new ProjectETAResponse();
		response.setProjectName(project.getProjectName());
		response.setDescription(project.getDescription());
		response.setStartDate(project.getProjectStartDate());
		response.setEstimatedEndDate(DateUtils.convertDateToString(projectEndDate));
		return response;
	}
}
