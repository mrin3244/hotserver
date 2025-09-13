package com.sarathi.hotserver.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="todays_sale")
public class TodaysSale {

	private Integer menu;

	private Integer quantity;

	private Integer amount;

	@Column(name = "user_id")
	private String userId;

	@Id
	@Column(name = "log_dt")
	private Date logDt;

}
