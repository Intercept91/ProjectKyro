package com.kyro.projectmanagement.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
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
@Embeddable
public class User {
	@Id
	private String userId;
	private String userEmail;

}
