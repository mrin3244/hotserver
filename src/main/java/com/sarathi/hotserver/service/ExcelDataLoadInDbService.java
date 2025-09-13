package com.sarathi.hotserver.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Service;

import com.sarathi.hotserver.model.ExcelProduct;
import com.sarathi.hotserver.model.ExcelTransaction;
import com.sarathi.hotserver.repo.ExcelProductRepo;
import com.sarathi.hotserver.repo.ExcelTransactionRepo;

@Service
public class ExcelDataLoadInDbService {
	
	private ExcelTransactionRepo excelTransactionRepo;
	private ExcelProductRepo excelProductRepo;
	
	public ExcelDataLoadInDbService(ExcelTransactionRepo excelTransactionRepo, ExcelProductRepo excelProductRepo) {
		this.excelTransactionRepo = excelTransactionRepo;
		this.excelProductRepo = excelProductRepo;
	}

	public String addAllExcelTransactionSheetData(XSSFSheet sheet) {
		try {
		List<ExcelTransaction> transactionSheetDataList = new ArrayList<>();
		
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		// 1. You can obtain a rowIterator and columnIterator and iterate over them
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
		
			if(row.getCell(0).getStringCellValue().equals("Invoice Number")) {
				//System.out.println("do nothing for this header row");
			}else {
				String transactionDate = row.getCell(1).getStringCellValue();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				Date date = formatter.parse(transactionDate);
				
				transactionSheetDataList.add(new ExcelTransaction(
						row.getCell(0).getStringCellValue(), date, row.getCell(2).getStringCellValue(),
						(int)row.getCell(3).getNumericCellValue(), (int)row.getCell(4).getNumericCellValue(), (int)row.getCell(5).getNumericCellValue(),
						(int)row.getCell(6).getNumericCellValue(), (int)row.getCell(7).getNumericCellValue(), (int)row.getCell(8).getNumericCellValue(),
						(int)row.getCell(9).getNumericCellValue(), (int)row.getCell(10).getNumericCellValue(), (int)row.getCell(11).getNumericCellValue(),
						(int)row.getCell(12).getNumericCellValue(), (int)row.getCell(13).getNumericCellValue(), row.getCell(14).getStringCellValue(), 
						row.getCell(15).getStringCellValue(), row.getCell(16).getStringCellValue().equals(false)?false:true));
			}
		}
		excelTransactionRepo.saveAll(transactionSheetDataList);
		System.out.println("success");
		return "success";
		} catch(Exception e) {
			//System.out.println("failed");
			e.printStackTrace();
			return "unable to save Transaction sheet data";
		}
		
	}
	
	public String addAllExcelProductSheetData(XSSFSheet sheet) {
		try {
		List<ExcelProduct> productSheetDataList = new ArrayList<>();
		
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		// 1. You can obtain a rowIterator and columnIterator and iterate over them
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
		
			if(row.getCell(0).getStringCellValue().equals("Invoice Number")) {
				//System.out.println("do nothing for this header row");
			}else {
				
				productSheetDataList.add(new ExcelProduct(
						row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(),
						row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), (int)row.getCell(5).getNumericCellValue(),
						(int)row.getCell(6).getNumericCellValue(), (int)row.getCell(7).getNumericCellValue(), row.getCell(8).getStringCellValue(),
						(int)row.getCell(9).getNumericCellValue(), row.getCell(10).getStringCellValue()));
			}
		}
		excelProductRepo.saveAll(productSheetDataList);
		System.out.println("success");
		return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "unable to save Product sheet data";
		}
		
	}

}
