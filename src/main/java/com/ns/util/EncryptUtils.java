package com.ns.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Michael Smith on 2016/8/2.
 */

public class EncryptUtils {
    /**
     * convert into MD5
     */
    public static String encryptMD5(String data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return new BigInteger(md5.digest(data.getBytes())).toString(16);
    }

    /**
     * Convert into SHA
     */
    public static String encryptSHA(String data) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        return new BigInteger(sha.digest(data.getBytes())).toString(32);
    }
}
