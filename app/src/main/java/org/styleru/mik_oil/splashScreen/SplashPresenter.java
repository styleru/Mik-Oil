package org.styleru.mik_oil.splashScreen;


import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    void isUserRegistered() {
        boolean registered = false;
        // Check if the user registered.

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() -> {

            if (registered) {
                getViewState().goToMain();
            } else {
                getViewState().goToEntrance();
            }
        }, 2000);
    }
}
