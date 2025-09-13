package com.sarathi.hotserver.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sarathi.hotserver.config.MySession;
import com.sarathi.hotserver.service.ExcelDataLoadInDbService;

@RestController
public class PosDataController {
	
	ExcelDataLoadInDbService excelDataLoadInDbService;
	
	public PosDataController(ExcelDataLoadInDbService excelDataLoadInDbService) {
		this.excelDataLoadInDbService = excelDataLoadInDbService;
	}



	@PostMapping("uploadPosExcel")
	public Object uploadPosExcel(MultipartFile posExcelFile) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "";
		try {
				//if (MySession.isAdmin()) {
				if(posExcelFile != null) {
					XSSFWorkbook workbook = new XSSFWorkbook(posExcelFile.getInputStream());
					Integer numberOfSheet = workbook.getNumberOfSheets();
					
					for (int i = 0; i < numberOfSheet; i++) {
						// Getting the Sheet at index i
						XSSFSheet sheet = workbook.getSheetAt(i);
						if(sheet.getSheetName().equals("Transaction")) {
							msg = excelDataLoadInDbService.addAllExcelTransactionSheetData(sheet);
						}else if(sheet.getSheetName().equals("Product")) {
							msg = excelDataLoadInDbService.addAllExcelProductSheetData(sheet);
						}
					}
					//msg = "success";
				} else {
					msg = "Invalid POS excel file...!!";
				}
				/*} else {msg = "Unauthorized access...!!";}*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg = "unable to upload excel sheet";
			}

		map.put("msg", msg);
		return map;
	}

}
