package com.kyro.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kyro.projectmanagement.model.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long>{
	

}
