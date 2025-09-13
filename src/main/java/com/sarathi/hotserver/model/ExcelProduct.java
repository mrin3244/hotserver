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
@IdClass(ExcelProductKey.class)
@Table(name="excel_product")
public class ExcelProduct {

	@Id
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Id
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "sales_price")
	private int salesPrice;
	
	@Column(name = "product_cost")
	private int productCost;
	
	@Column(name = "qty")
	private int qty;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "note")
	private String note;
}
