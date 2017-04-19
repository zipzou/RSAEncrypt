package site.franksite.encrpt.rsaencrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import org.apache.commons.codec.binary.Base64;

public class Signaturer extends KeyManager implements RSASignaturer {

	/* (non-Javadoc)
	 * @see site.franksite.encrpt.rsaencrypt.RSASignaturer#sign(byte[], byte[])
	 */
	public byte[] sign(byte[] priKey, byte[] data) {
		PrivateKey privateKey = restorePrivateKey(priKey);
		
		try {
			Signature sign = Signature.getInstance("MD5withRSA");
			sign.initSign(privateKey);
			sign.update(data);
			return Base64.encodeBase64(sign.sign());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/* (non-Javadoc)
	 * @see site.franksite.encrpt.rsaencrypt.RSASignaturer#verify(byte[], byte[], byte[])
	 */
	public boolean verify(byte[] pubKey, byte[] data, byte[] originData) {
		PublicKey publicKey = restorePublicKey(pubKey);
		Signature sign;
		try {
			sign = Signature.getInstance("MD5withRSA");
			sign.initVerify(publicKey);
			sign.update(originData);
			return sign.verify(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
