package com.kyro.projectmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Embeddable
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;

	private Long storyId;

	private String title;

	private String owner;
	
	private String type;

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Task> childTask;

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Resource> resources;

	private Integer estimatedTime;

}
