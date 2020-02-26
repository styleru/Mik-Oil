package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class PresenterLogin extends MvpPresenter<ViewLogin> {

    void sendingRequest(String login, String password) {
        if(ifDataNotNull(login, password)) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().changeProgressState(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);
                if(rand % 2 == 0) {
                    getViewState().showToast(R.string.success);
                    getViewState().goToEntrance();
                }
                else {
                    getViewState().changeProgressState(false);
                    getViewState().showToast(R.string.login_error);
                }
            }, 2000);
        }
        else {
            getViewState().changeProgressState(false);
            getViewState().showToast(R.string.empty_fields);
        }
    }

    private boolean ifDataNotNull(String login, String password) {
        return (!login.isEmpty()) && (!password.isEmpty());
    }
}
