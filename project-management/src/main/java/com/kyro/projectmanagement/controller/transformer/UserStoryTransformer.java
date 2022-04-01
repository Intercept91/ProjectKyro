package com.kyro.projectmanagement.controller.transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.kyro.projectmanagement.model.UserStory;
import com.kyro.projectmanagement.model.dto.request.UserStoryPlan;

public class UserStoryTransformer implements Function<List<UserStoryPlan>, List<UserStory>> {

	@Override
	public List<UserStory> apply(List<UserStoryPlan> plans) {
		List<UserStory> stories = new ArrayList<>();
		if (plans == null)
			return Collections.emptyList();
		else {
			for (UserStoryPlan plan : plans) {
				UserStory story = new UserStory();
				story.setProjectId(plan.getProjectId());
				story.setTitle(plan.getTitle());
				story.setDescription(plan.getDescription());
				stories.add(story);
			}
			
		}
		return stories;
	}

}
