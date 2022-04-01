package com.kyro.projectmanagement.controller.transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.kyro.projectmanagement.model.Task;
import com.kyro.projectmanagement.model.dto.request.TaskPlan;

public class TaskTransformer implements Function<List<TaskPlan>, List<Task>> {

	@Override
	public List<Task> apply(List<TaskPlan> plans) {
		List<Task> taskList = new ArrayList<>();
		if (plans == null)
			return Collections.emptyList();
		else {
			for (TaskPlan plan : plans) {
				Task task = new Task();
				task.setStoryId(plan.getUserStoryId());
				task.setTitle(plan.getTitle());
				task.setOwner(plan.getOwner());
				task.setResources(plan.getResources());
				task.setChildTask(plan.getChildTasks());
				task.setEstimatedTime(plan.getEstimatedTime());
				taskList.add(task);
			}
			
		}
		return taskList;
	}

}