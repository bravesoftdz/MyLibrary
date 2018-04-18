package by.htp.library.action.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encryption {

	public String enCodePassword(String password) {		
		String md5Hex = DigestUtils.md5Hex(password);
		return md5Hex;
	}

}
