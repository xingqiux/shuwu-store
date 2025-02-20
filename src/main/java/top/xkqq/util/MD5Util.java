package top.xkqq.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util{
    /**
     * @Title: md5Lower
     * @Description:不加盐值32位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5(String plainText) {
        String md5 = null;
        if (null != plainText && !"".equals(plainText)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes("UTF-8"));
                md5 =  new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return md5;
    }
}
