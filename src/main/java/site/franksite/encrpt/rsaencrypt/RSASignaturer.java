/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

/**
 * RSA签名接口
 * @author Frank
 *
 */
public interface RSASignaturer {

	/**
	 * 对数据进行数字签名
	 * @param priKey 签名所用的私钥字节流数据
	 * @param data 要签名的数据字节流
	 * @return 签名后的数据字节流，数据经Base64加密
	 */
	public byte[] sign(byte[] priKey, byte[] data);
	
	/**
	 * 验证数字签名是否正确
	 * @param pubKey 进行签名认证的公钥
	 * @param data 已签名数据
	 * @param originData 原始数据
	 * @return 该签名数据，是否为原始数据，若一致，则为true，否则为false
	 */
	public boolean verify(byte[] pubKey, byte[] data, byte[] originData);
	
}
