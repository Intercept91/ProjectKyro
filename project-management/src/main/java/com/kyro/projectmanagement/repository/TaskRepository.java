package com.kyro.projectmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.kyro.projectmanagement.model.Task;

@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task,Long>{
	
	 List<Task> findByStoryId(@Param("storyId") Long storyId);
	 

}
