package org.styleru.mik_oil;

import android.app.Application;
import android.content.Context;

public class MikOilApplication extends Application {

    private static Application INSTANCE;

    public static Context getAppContext() {
        return INSTANCE.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}