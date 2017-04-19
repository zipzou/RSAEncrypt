/**
 * 
 */
package site.franksite.encrpt.rsaencrypt;

/**
 * RSA加密接口
 * @author Frank
 *
 */
public interface RSAEncrypt {

	/**
	 * 公钥加密
	 * @param pubKey 进行加密锁使用的RSA公钥字节码
	 * @param data 要加密的数据字节流
	 * @return 加密后的密文数据字节流
	 */
	public byte[] encrypt(byte[] pubKey, byte[] data);
	
	/**
	 * 私钥解密
	 * @param priKey 进行解密所使用的RSA私钥字节流文件
	 * @param data 要解密的密文字节流
	 * @return 解密后的明文数据字节流
	 */
	public byte[] dencrypt(byte[] priKey, byte[] data);
	
}
