package com.ns.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.File;

/**
 * Created by Michael Smith on 2016/8/2.
 */

public class DeviceUtils {

    public static String getMacAddress(Context context) {
        String macAddress = null;
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        if (null != info ) {
            macAddress = info.getMacAddress();
            if (null != macAddress) {
                macAddress = macAddress.replace(":", "");
            }
        }
        return macAddress;
    }

    /**
     * Get equipment manufacturers such as Xiaomi
     */
    public static String getManufacturer() {
        String MANUFACTURER = Build.MANUFACTURER;
        return MANUFACTURER;
    }

    /**
     * Get device models, such as MI2SC
     */
    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }

    /**
     * Get device SD card is available
     */
    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * Get device SD card path
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    /**
     * Determine whether the device is a mobile phone
     */
    public static boolean isPhone(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
    }

    /**
     * Gets Device IMEI number
     * Need <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
     * @param context
     * @return string
     */
    public static String getDeviceIMEI(Context context) {
        String deviceId;
        if (isPhone(context)) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
        } else {
            deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return deviceId;
    }

}
