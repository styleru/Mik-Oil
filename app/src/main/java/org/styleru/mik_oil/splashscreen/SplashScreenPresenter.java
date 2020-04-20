package org.styleru.mik_oil.splashscreen;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashScreenPresenter extends MvpPresenter<SplashScreenView> {

    void checkRegistration() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            if (false) {
                getViewState().goToMain();
            } else {
                //getViewState().goToEntrance();
                getViewState().goToProfile();
            }
        }, 2000);
    }
}