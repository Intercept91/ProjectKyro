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
public class Resource {
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private Long resourceId;
	private String resourceName;
	private String resourceType;
	private Integer hours;
}


