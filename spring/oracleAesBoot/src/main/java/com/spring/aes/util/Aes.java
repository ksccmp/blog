package com.spring.aes.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class Aes {
	
	private String secretKey = "12345678901234567890123456789012"; // 비밀키
	
	// 암호화
	public String encryption(String text) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE,
						new SecretKeySpec(secretKey.getBytes(), "AES"),
						new IvParameterSpec(new byte[16]));
			
			return new String(Base64.getEncoder().encode(cipher.doFinal(text.getBytes("UTF-8"))));
		} catch(Exception e) {
			return text;
		}
	}
	
	// 복호화
	public String decryption(String encryptedText) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE,
						new SecretKeySpec(secretKey.getBytes(), "AES"),
						new IvParameterSpec(new byte[16]));
			
			return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText.getBytes("UTF-8"))));
		} catch(Exception e) {
			return encryptedText;
		}
	}
}
