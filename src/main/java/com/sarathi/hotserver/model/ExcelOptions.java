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
@IdClass(ExcelOptionsKey.class)
@Table(name="excel_options")
public class ExcelOptions {

	@Id
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Id
	@Column(name = "log_date")
	private Date logDate;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "options")
	private String options;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "sale_price")
	private String salePrice;
	
	@Column(name = "product_cost")
	private String productCost;
	
	@Column(name = "qty")
	private String qty;
	
	@Column(name = "total")
	private String total;
	
	
}
