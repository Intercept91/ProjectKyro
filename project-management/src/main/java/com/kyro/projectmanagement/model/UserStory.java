package com.kyro.projectmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class UserStory {
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private Long storyId;
	private Long projectId;
	private String title;
	private String description;

	private String storyStartDate;
}

