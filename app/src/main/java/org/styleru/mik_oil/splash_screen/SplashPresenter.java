package org.styleru.mik_oil.splash_screen;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.MvpPresenter;

public class SplashPresenter extends MvpPresenter<SplashView> {
    void isAuthorised(boolean key){

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() -> {

            if (key){
                // going to Main
            } else{
                getViewState().goToEntrance();
            }
        }, 2000);

    }
}
