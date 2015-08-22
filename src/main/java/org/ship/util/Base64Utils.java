package org.ship.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * BASE64编码解码工具包
 * @author Rabbits
 * @date 2015-8-21
 * @version 1.0
 * 
 */
public class Base64Utils {
	
	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;
	
	/**
	 * BASE64字符串解码为二进制数据
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode(String base64) throws Exception {
		return Base64.decodeBase64(base64);
	}
	
	/**
	 * 二进制数据编码为BASE64字符串
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] bytes) throws Exception {
		return new String(Base64.encodeBase64(bytes));
	}
	
	/**
	 * 将文件编码为BASE64字符串
	 * 大文件慎用，可能会导致内存溢出
	 * @param filePath 文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static String encodeFile(String filePath) throws Exception {
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}
	
	/**
	 * BASE64字符串转会文件
	 * @param filePath
	 * @param base64
	 * @throws Exception
	 */
	public static void decodeToFile(String filePath, String base64)
		throws Exception {
		byte[] bytes = decode(base64);
		byteArrayToFile(bytes, filePath);
	}
	
	/**
	 * 文件转换为二进制数组
	 * @param filePath 文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static byte[] fileToByte(String filePath)
		throws Exception {
		byte[] data = new byte[0];
		File file = new File(filePath);
		if( file.exists()) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while((nRead = in.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}
			out.close();
			in.close();
			data = out.toByteArray();
		}
		return data;
	}
	
	public static void byteArrayToFile(byte[] bytes, String filePath)
		throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if(!destFile.getParentFile().exists()){
			destFile.getParentFile().mkdirs();
		}
		destFile.createNewFile();
		OutputStream out = new FileOutputStream(destFile);
		byte[] cache = new byte[CACHE_SIZE];
		int nRead = 0;
		while ((nRead = in.read(cache)) != -1) {
			out.write(cache, 0, nRead);
			out.flush();
		}
		out.close();
		in.close();
	}
}
