package org.styleru.mik_oil;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    void onLoginClicked(String login, String password) {
        if(isNotEmpty(login, password)) {
            Handler handler = new Handler();

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().setProgressEnabled(false);
                getViewState().goToMain();

                if (rand == 1)
                    getViewState().showToast(1);
                else if (rand == 0) getViewState().showToast(0);
            }, 2000);
        }
        else getViewState().showToast(3);
    }

    private boolean isNotEmpty(String login, String password) {
        return (login.length() != 0) && (password.length() != 0);
    }
}