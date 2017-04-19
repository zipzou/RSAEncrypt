package site.franksite.encrpt.rsaencrypt;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class SignaturerTest {

	private RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
	private String content = "This is the content to signature";
	
	@Test
	public void testSign() {
		// 测试签名
		
		RSASignaturer sign = new Signaturer();
		
		byte[] privateKeyEncoded = keyGenerator.getPrivateKeyEncoded();
		
		try {
			byte[] signedData = sign.sign(Base64.decodeBase64(privateKeyEncoded), content.getBytes("utf-8"));
			System.out.println(new String(signedData, "utf-8"));
			testVerify(new String(signedData, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void testVerify(String data) {
		byte[] publicKeyEncoded = keyGenerator.getPublicKeyEncoded();
		
		RSASignaturer sign = new Signaturer();
		try {
			boolean verify = sign.verify(Base64.decodeBase64(publicKeyEncoded), Base64.decodeBase64(data.getBytes("utf-8")), content.getBytes("utf-8"));
			assertTrue(verify);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
