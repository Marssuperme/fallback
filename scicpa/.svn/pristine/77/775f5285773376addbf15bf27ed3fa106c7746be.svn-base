package cn.org.gdicpa.web.pub.util;

import java.security.*;

/**
 *
 * <p>Title: 不可逆加密算法</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MD5 {
  public MD5() {
  }

  /**
   * 不可逆加密函数
   * @param s  ：待加密字符串,
   * @return  ：  加密后字符串，如果待加密字符串为null，则返回null
   */
  public final static String getMD5String(String s) {
    char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
        'e', 'f'};
    try {
      byte[] strTemp = s.getBytes();
      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
      mdTemp.update(strTemp);
      byte[] md = mdTemp.digest();
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str);
    }
    catch (Exception e) {
      return null;
    }
  }

  public static void main(String[] args) {
//    System.out.println(MD5.getMD5String("测试1010111010GDicpa5618586").toUpperCase());
//    System.out.println(MD5.getMD5String("matech3").toUpperCase());
	  System.out.println(MD5.getMD5String("周海燕2120110041SCicpa#9112014-06-12 14:48:24"));//8df3548c4876453b27bb58d6889c5dd8
	  System.out.println(MD5.getMD5String("周海燕2120110041SCicpa#9112014-06-12 21:02:24"));//6f49e5cd80aacc0035bf71ded0c93adc
	  //a83340d90306c3675a0f3e6ea0e40f11
	  System.out.println(MD5.getMD5String("周海燕2120110041SCicpa#8222014-06-12 21:26:14"));//32350c3c73cb77f869d400428b3a56c5
	  
//	  1ba02f9bf66c47f1a554407f83cfb62c
//	  b2db73f04b84a490fb964b9e86b462e9
  }


}



