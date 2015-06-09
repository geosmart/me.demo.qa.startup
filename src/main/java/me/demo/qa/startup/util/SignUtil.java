package me.demo.qa.startup.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 * Signature-工具类
 * 
 * @author geosmart
 */
public class SignUtil {

  /**
   * 与接口配置信息中的 token 要一致，这里赋予什么值，在接口配置信息中的Token就要填写什么值，
   * 两边保持一致即可，建议用项目名称、公司名称缩写等，我在这里用的是项目名称qa.startup
   */
  private static String token = "qa.startup";

  /**
   * 验证签名
   * 
   * @param signature
   * @param timestamp
   * @param nonce
   * @return
   */
  public static boolean checkSignature(String signature, String timestamp, String nonce) {
    String[] arr = new String[] {token, timestamp, nonce};
    // 将 token, timestamp, nonce 三个参数进行字典排序
    Arrays.sort(arr);
    StringBuilder content = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      content.append(arr[i]);
    }
    MessageDigest md = null;
    String tmpStr = null;

    System.out.println(signature);
    System.out.println(timestamp);
    System.out.println(nonce);
    try {
      md = MessageDigest.getInstance("SHA-1");
      // 将三个参数字符串拼接成一个字符串进行 shal 加密
      byte[] digest = md.digest(content.toString().getBytes());
      tmpStr = byteToStr(digest);
      System.out.println("-------tmpStr");
      System.out.println(tmpStr);
    } catch (NoSuchAlgorithmException e) { 
      e.printStackTrace();
    }
    content = null;
    // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
    return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
  }

  /**
   * 将字节数组转换为十六进制字符串
   * 
   * @param digest
   * @return
   */
  private static String byteToStr(byte[] digest) {
    // TODO Auto-generated method stub
    String strDigest = "";
    for (int i = 0; i < digest.length; i++) {
      strDigest += byteToHexStr(digest[i]);
    }
    return strDigest;
  }

  /**
   * 将字节转换为十六进制字符串
   * 
   * @param b
   * @return
   */
  private static String byteToHexStr(byte b) {
    // TODO Auto-generated method stub
    char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    char[] tempArr = new char[2];
    tempArr[0] = Digit[(b >>> 4) & 0X0F];
    tempArr[1] = Digit[b & 0X0F];

    String s = new String(tempArr);
    return s;
  }
}
