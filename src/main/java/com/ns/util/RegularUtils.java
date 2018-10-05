package com.ns.util;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by Michael Smith on 2016/8/2.
 */

public class RegularUtils {
    // For mobile number validation
    private static final String REGEX_MOBILE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    // To display contact number：xxx/xxxx-xxxxxxx/xxxxxxxx
    private static final String REGEX_TEL = "^0\\d{2,3}[- ]?\\d{7,8}";
    // Email Regular Expression
    private static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    // Url Regular Expression
    private static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";

    private static final String REGEX_CHZ = "^[\\u4e00-\\u9fa5]+$";
    //User Name regular expression
    private static final String REGEX_USERNAME = "^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$";

    //If u want more please visit http://toutiao.com/i6231678548520731137/

    /**
     * @param string Mobile Number
     * @return boolean, whether it is valid mobile number or not.
     */
    public static boolean isMobile(String string) {
        return isMatch(REGEX_MOBILE, string);
    }

    /**
     * @param string Telephone Number
     * @return boolean, whether it is valid telephone number or not.
     */
    public static boolean isTel(String string) {
        return isMatch(REGEX_TEL, string);
    }

    /**
     * @param string Email
     * @return boolean, whether it is valid email or not.
     */
    public static boolean isEmail(String string) {
        return isMatch(REGEX_EMAIL, string);
    }

    /**
     * @param string URL
     * @return boolean, whether it is valid URL or not.
     */
    public static boolean isURL(String string) {
        return isMatch(REGEX_URL, string);
    }

    /**
     * @param string
     * @return
     */
    public static boolean isChz(String string) {
        return isMatch(REGEX_CHZ, string);
    }

    /**
     * @param string UserName
     * @return boolean, whether it is valid user name or not.
     */
    public static boolean isUsername(String string) {
        return isMatch(REGEX_USERNAME, string);
    }

    /**
     * @param regex  regular expression string
     * @param string to be validated string
     * @return boolean
     */
    public static boolean isMatch(String regex, String string) {
        return !TextUtils.isEmpty(string) && Pattern.matches(regex, string);
    }
}
