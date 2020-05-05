package org.styleru.mik_oil;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper {

    private static final String SP_NAME = "my_app_sp";
    private static final String LOGIN_KEY = "sp_login";

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
}
