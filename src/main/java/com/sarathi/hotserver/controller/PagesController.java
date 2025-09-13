package com.sarathi.hotserver.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PagesController implements ErrorController {
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/error")
	public String handleError(HttpServletResponse response) {
		return "error";
	}
	
	/********************************************************
	 ********************* ADMIN PAGES **********************
	 ********************************************************/
	
	@GetMapping("/salesEntry")
	public String salesEntry() {
		return "admin/salesEntry";
	}

	@GetMapping("/salesEntryAdmin")
	public String salesEntryAdmin() {
		return "admin/salesEntryAdmin";
	}
	
	@GetMapping("/menuManage")
	public String menuManage() {
		return "admin/menuManage";
	}
}
