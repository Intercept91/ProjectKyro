package com.kyro.projectmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kyro.projectmanagement.model.Project;

@EnableJpaRepositories
public interface ProjectRepository extends JpaRepository<Project,Long> {
	
	   

}
