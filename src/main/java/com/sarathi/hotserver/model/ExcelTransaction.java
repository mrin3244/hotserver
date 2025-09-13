package com.sarathi.hotserver.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="excel_transaction")
public class ExcelTransaction {

	@Id
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "sales_price")
	private int salesPrice;
	
	@Column(name = "product_cost")
	private int productCost;
	
	@Column(name = "service_fee")
	private int serviceFee;
	
	@Column(name = "tax")
	private int tax;
	
	@Column(name = "delivery_fee")
	private int deliveryFee;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "revenue")
	private int revenue;
	
	@Column(name = "grand_total")
	private int grandTotal;
	
	@Column(name = "total_paid")
	private int totalPaid;
	
	@Column(name = "balance")
	private int balance;
	
	@Column(name = "profit")
	private int profit;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "inclusive_tax")
	private boolean inclusiveTax;
}
