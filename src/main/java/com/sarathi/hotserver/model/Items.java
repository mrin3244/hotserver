package com.sarathi.hotserver.model;

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
@Table(name="items")
public class Items {
	
	@Id
	private Integer id;
	
	private Integer category;
	
	private String description;
	
	private Integer price;
	
	private Integer weightage;

}
