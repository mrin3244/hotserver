package com.sarathi.hotserver.config;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

public class MySession {

	private static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}

	public static void set(String name, String value) {
		session().setAttribute(name, value);
	}

	public static boolean isLoggedIn() {
		return session().getAttribute("userId") != null;
	}

	public static boolean isSalesPerson() {
		return session().getAttribute("userId") != null 
				&& session().getAttribute("role") != null
				&& session().getAttribute("role").toString().equals("SALES");
	}

	public static boolean isAdmin() {
		return session().getAttribute("userId") != null 
				&& session().getAttribute("role") != null
				&& session().getAttribute("role").toString().equals("ADMIN");
	}
	
	public static String getUserId() {
		return session().getAttribute("userId") != null
				&& session().getAttribute("role") != null ? 
						session().getAttribute("userId").toString() : null;
	}
	
	public static void destroy() {
		session().invalidate();
	}

}
