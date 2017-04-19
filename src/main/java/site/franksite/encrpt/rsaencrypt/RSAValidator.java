/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA加密验证者，用于私钥解密
 * 
 * @author frank
 *
 */
public class RSAValidator extends KeyManager implements RSAEncrypt {

	private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // 加密算法

	/*
	 * (non-Javadoc)
	 * 
	 * @see site.franksite.encrpt.rsaencrypt.RSAEncrypt#dencrypt(byte[], byte[])
	 */
	public byte[] dencrypt(byte[] priKey, byte[] data) {
		// 还原私钥
		PrivateKey privateKey = restorePrivateKey(priKey);

		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see site.franksite.encrpt.rsaencrypt.RSAEncrypt#encrypt(byte[], byte[])
	 */
	public byte[] encrypt(byte[] pubKey, byte[] data) {
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

}
