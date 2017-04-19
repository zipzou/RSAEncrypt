package site.franksite.encrpt.rsaencrypt;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class KeyGenearatorTest {

	@Test
	public void testGenerator() {
		RSAKeyGenerator generator = new RSAKeyGenerator();
		byte[] pub = generator.getPublicKeyEncoded();
		byte[] pri = generator.getPrivateKeyEncoded();
		
		try {
			System.out.println(new String(pub, "utf-8"));
			System.out.println(new String(pri, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
