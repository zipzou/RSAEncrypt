/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 抽象密钥管理类
 * 
 * @author Frank
 *
 */
public abstract class KeyManager {

	private static final String ENCRYPT_ALGORITHM = "RSA";// 加密算法

	private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // 加密算法

	/**
	 * 将私钥字节码转为私钥实例
	 * @param pivateKey RSA私钥字节码
	 * @return 私钥实例
	 */
	public PrivateKey restorePrivateKey(byte[] pivateKey) {

		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pivateKey);

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

	/**
	 * 将公钥字节码转为公钥实例
	 * @param publicKey RSA公钥字节码
	 * @return 公钥实例
	 */
	public PublicKey restorePublicKey(byte[] publicKey) {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
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
