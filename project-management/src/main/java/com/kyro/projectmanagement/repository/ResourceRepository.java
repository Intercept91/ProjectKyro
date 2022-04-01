package com.kyro.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kyro.projectmanagement.model.Resource;

@EnableJpaRepositories
public interface ResourceRepository extends JpaRepository<Resource,Long>{

}
