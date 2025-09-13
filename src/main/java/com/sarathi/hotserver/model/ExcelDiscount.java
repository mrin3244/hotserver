package com.sarathi.hotserver.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ExcelDiscountKey.class)
@Table(name="excel_discount")
public class ExcelDiscount {

	@Id
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Id
	@Column(name = "log_date")
	private Date logDate;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "promo_code")
	private String promoCode;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "qty")
	private String qty;
	
	@Column(name = "total")
	private String total;
}
