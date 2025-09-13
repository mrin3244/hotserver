package com.sarathi.hotserver.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(DailySaleKey.class)
@Table(name="daily_sale")
public class DailySale {

	@Id
	@Column(name = "sale_date")
	private Date saleDate;

	@Id
	private Integer category;

	@Column(name = "sale_amount")
	private Integer saleAmount;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "log_dt")
	private Date logDt;

}
