package net.xdclass.online_xdclass.utils;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.utils
 * @ClassName : CommonUtils.java
 * @createTime : 2022/3/6 12:30
 * @Email : 874280179@qq.com
 * @Description :
 */
public class CommonUtils {

    /**
     * MD5加密工具类
     * @param data
     * @return
     */
    public static String MD5(String data)  {
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;

    }

}
