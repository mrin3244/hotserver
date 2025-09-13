package com.sarathi.hotserver.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryption {
	
	public static String bCryptHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public static boolean verifyBCryptHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}