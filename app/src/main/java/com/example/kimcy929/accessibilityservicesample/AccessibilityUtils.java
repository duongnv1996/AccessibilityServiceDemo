package com.example.kimcy929.accessibilityservicesample;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by kimcy929 on 7/9/2017.
 * https://stackoverflow.com/a/18095283
 */

public class AccessibilityUtils {

    private static final String TAG = AccessibilityUtils.class.getSimpleName();

    public static boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = mContext.getPackageName() + "/" + MyAccessibilityService.class.getCanonicalName();
        boolean accessibilityFound = false;

        try {
            accessibilityEnabled = Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            Log.e(TAG, "Error finding setting, default accessibility to not found: "
                    + e.getMessage());
        }

        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            Log.v(TAG, "***ACCESSIBILIY IS ENABLED*** -----------------");
            String settingValue = Settings.Secure.getString(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                TextUtils.SimpleStringSplitter splitter = mStringColonSplitter;
                splitter.setString(settingValue);
                while (splitter.hasNext()) {
                    String accessabilityService = splitter.next();

                    Log.v(TAG, "-------------- > accessabilityService :: " + accessabilityService);

                    if (accessabilityService.equalsIgnoreCase(service)) {
                        Log.v(TAG, "We've found the correct setting - accessibility is switched on!");
                        return true;
                    }
                }
            }
        }

        return accessibilityFound;
    }
}
