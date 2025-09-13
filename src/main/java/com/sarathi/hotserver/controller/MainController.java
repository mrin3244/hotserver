package com.sarathi.hotserver.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sarathi.hotserver.config.MySession;
import com.sarathi.hotserver.model.UserInfo;
import com.sarathi.hotserver.repo.UserInfoRepo;
import com.sarathi.hotserver.util.Encryption;

@Controller
public class MainController {

	@Autowired
	private UserInfoRepo userRepo;

	@GetMapping({ "/", "/home" })
	public String home() {
		if (MySession.isSalesPerson()) {
			return "admin/salesEntry";
		} else if (MySession.isAdmin()) {
			return "admin/salesEntryAdmin";
		} else {
			return "index";
		}

	}

	@GetMapping({ "/login" })
	public String loginPage() {
		MySession.destroy();
		return "admin/login";
	}

	@GetMapping({ "/logout" })
	public String logout() {
		MySession.destroy();
		return "index";
	}

	/**
	 * before login check database that all table have value
	 * @param userId any string
	 * @param password must be Encryption by BCrypt.hashpw(password, BCrypt.gensalt(10))
	 * @return
	 */
	@PostMapping("/login")
	public @ResponseBody Object login(String userId, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "";
		try {
			Optional<UserInfo> user = this.userRepo.findById(userId);
			if (user.isPresent()) {
				if (Encryption.verifyBCryptHash(password, user.get().getUserPassword())) {
					MySession.set("userId", ((UserInfo) user.get()).getUserId());
					MySession.set("userName", ((UserInfo) user.get()).getUserName());
					MySession.set("role", ((UserInfo) user.get()).getUserType());
					msg = "success";
				} else {
					msg = "Invalid password...!!";
				}
			} else {
				msg = "User not found...!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong...!!";
		}
		map.put("msg", msg);
		return map;
	}

}
