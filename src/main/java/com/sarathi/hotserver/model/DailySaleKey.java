package com.sarathi.hotserver.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailySaleKey implements Serializable{

	private static final long serialVersionUID = 6734833289878335559L;
	private Date saleDate;
	private Integer category;

}
