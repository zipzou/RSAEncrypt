/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA加密验证者，用于私钥解密
 * @author frank
 *
 */
public class RSAValidator {

	private static final String ENCRYPT_ALGORITHM = "RSA";// 加密算法
	
	private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // 加密算法
	
	/**
	 * 使用私钥对数据进行解密
	 * @param privateKey 私钥
	 * @param data 待解密密文数据
	 * @return 明文数据
	 */
	public byte[] dencrypt(byte[] privateKey, byte[] data) {
		
		// 还原私钥
		PrivateKey priKey = restorePrivateKey(privateKey);
		
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public byte[] encrypt(byte[] pubKey, byte[]data) {
		
		PublicKey key = restorePublicKey(pubKey);
		
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private PrivateKey restorePrivateKey(byte[] pivateKey) {
		
		PKCS8EncodedKeySpec  keySpec = new PKCS8EncodedKeySpec (pivateKey);
		
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPT_ALGORITHM);
			PrivateKey key = keyFactory.generatePrivate(keySpec);
			return key;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private PublicKey restorePublicKey(byte[] publicKey) {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec (publicKey);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPT_ALGORITHM);
			PublicKey pubKey = keyFactory.generatePublic(keySpec);
			return pubKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
