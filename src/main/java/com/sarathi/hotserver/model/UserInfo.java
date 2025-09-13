package com.sarathi.hotserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user_info")
public class UserInfo {
	
	@Id
	@Column(name = "user_id")
	private String userId; 

	@Column(name = "user_name")
	private String userName; 

	@Column(name = "user_password")
	private String userPassword; 

	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_status")
	private String userStatus;

}
