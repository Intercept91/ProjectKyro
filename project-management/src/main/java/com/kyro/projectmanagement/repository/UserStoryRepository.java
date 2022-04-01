package com.kyro.projectmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.kyro.projectmanagement.model.UserStory;

@EnableJpaRepositories
public interface UserStoryRepository extends JpaRepository<UserStory,Long>{
	
	 List<UserStory> findByProjectId(@Param("projectId") Long projectId);
}
