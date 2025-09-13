package com.sarathi.hotserver.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelOptionsKey  implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private String invoiceNumber;
	
	private Date logDate;
	
}
