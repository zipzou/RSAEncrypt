/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA密钥生成类
 * @author frank
 *
 */
public class RSAKeyGenerator {

	private byte[] publicKeyEncoded;
	private byte[] privateKeyEncoded;
	
	private static final int KEY_LENGTH = 1024;
	
	public void generate() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			SecureRandom secRandom = new SecureRandom();
			secRandom.setSeed(new Date().getTime());
			
			generator.initialize(KEY_LENGTH, secRandom);
			
			// 产生键值对
			KeyPair pair = generator.generateKeyPair();
			
			PublicKey pubKey = pair.getPublic();
			PrivateKey priKey = pair.getPrivate();
			
			// 加密公钥私钥
			publicKeyEncoded = Base64.encodeBase64(pubKey.getEncoded());
			privateKeyEncoded = Base64.encodeBase64(priKey.getEncoded());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the publicKeyEncoded
	 */
	public byte[] getPublicKeyEncoded() {
		
		if (null == publicKeyEncoded) {
			generate();
		}
		
		return publicKeyEncoded;
	}

	/**
	 * @return the privateKeyEncoded
	 */
	public byte[] getPrivateKeyEncoded() {
		if (null == privateKeyEncoded) {
			generate();
		}
		return privateKeyEncoded;
	}
	
}
