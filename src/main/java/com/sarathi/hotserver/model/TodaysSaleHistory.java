package com.sarathi.hotserver.model;

import java.util.Date;

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
@Table(name="todays_sale_history")
public class TodaysSaleHistory {

	private Integer menu;

	private Integer quantity;

	private Integer amount;

	@Column(name = "user_id")
	private String userId;

	@Id
	@Column(name = "log_dt")
	private Date logDt;

	@Column(name = "compiled_by")
	private String compiledBy;

	@Column(name = "compiled_on")
	private Date compiledOn;

}
