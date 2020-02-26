package org.styleru.mik_oil;

import android.app.Application;

public class MikOilApplication extends Application {

    private static Application INSTANCE;

    public static Application getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}