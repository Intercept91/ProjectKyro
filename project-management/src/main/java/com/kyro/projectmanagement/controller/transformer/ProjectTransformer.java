package com.kyro.projectmanagement.controller.transformer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.kyro.projectmanagement.model.Project;
import com.kyro.projectmanagement.model.dto.request.ProjectPlan;

public class ProjectTransformer implements  Function<ProjectPlan, List<Project>>{

	@Override
	public List<Project> apply(ProjectPlan plan) {
		Project project = new Project();
		if(plan == null)
			return Arrays.asList(project);
		else
		{
			project.setProjectName(plan.getProjectName());
			project.setProjectStartDate(plan.getStartDate());
			project.setDescription(plan.getDescription());
		}
		return Arrays.asList(project);
	}

}
