package org.styleru.mik_oil;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper {

    private static final String SP_NAME = "my_app_sp";
    private static final String LOGIN_KEY = "sp_login";
    private static final String NAME_KEY = "sp_name";
    private static final String BALANCE_KEY = "sp_balance";
    private static final String IMAGE_KEY = "sp_image";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static String getLogin(Context context) {
        return getSharedPreferences(context).getString(LOGIN_KEY, null);
    }

    public static void setLogin(Context context, String login) {
        getSharedPreferences(context).edit()
                .putString(LOGIN_KEY, login)
                .apply();
    }

    public static String getName(Context context) {
        return getSharedPreferences(context).getString(NAME_KEY, null);
    }

    public static void setName(Context context, String name) {
        getSharedPreferences(context).edit()
                .putString(NAME_KEY, name)
                .apply();
    }

    public static String getBalance(Context context) {
        return getSharedPreferences(context).getString(BALANCE_KEY, null);
    }

    public static void setBalance(Context context, String bal) {
        getSharedPreferences(context).edit()
                .putString(BALANCE_KEY, bal)
                .apply();
    }

    public static String getImageUrl(Context context) {
        return getSharedPreferences(context).getString(IMAGE_KEY, null);
    }

    public static void setImageUrl(Context context, String url) {
        getSharedPreferences(context).edit()
                .putString(IMAGE_KEY, url)
                .apply();
    }
}
