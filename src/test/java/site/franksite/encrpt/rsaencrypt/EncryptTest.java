package site.franksite.encrpt.rsaencrypt;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class EncryptTest {

	@Test
	public void testEncrypt() {
		RSAKeyGenerator generalKey = new RSAKeyGenerator();
		byte[] privateKeyEncoded = generalKey.getPublicKeyEncoded();
		
		try {
			System.out.println(new String(privateKeyEncoded, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 加密
		RSAValidator validator = new RSAValidator();
		byte[] encryptPwd;
		try {
			encryptPwd = validator.encrypt(Base64.decodeBase64(privateKeyEncoded), "zouzhipeng123A".getBytes("utf-8"));
			System.out.println(encryptPwd.length);
			System.out.println(new String(Base64.encodeBase64(encryptPwd), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidate() {
		
		RSAKeyGenerator generalKey = new RSAKeyGenerator();
		byte[] publicKeyEncoded = generalKey.getPublicKeyEncoded();
		byte[] privateKeyEncoded = generalKey.getPrivateKeyEncoded();
		
		try {
			System.out.println(new String(publicKeyEncoded, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		RSAValidator validator = new RSAValidator();
		
		try {
			byte[] pwd = validator.encrypt(Base64.decodeBase64(publicKeyEncoded), "zouzhipeng123A".getBytes("utf-8"));
			byte[] dencrypt = validator.dencrypt(Base64.decodeBase64(privateKeyEncoded), pwd);
			String str = new String(dencrypt, "utf-8");
			assertEquals("zouzhipeng123A", str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
