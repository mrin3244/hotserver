package com.sarathi.hotserver.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelProductKey  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String invoiceNumber;
	
	private String itemName;

}
