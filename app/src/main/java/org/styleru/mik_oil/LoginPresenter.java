package org.styleru.mik_oil;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    void onLoginClicked(String login, String password) {
        if(checkNull(login, password)) {
            Handler handler = new Handler();

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().setProgressEnabled(false);

                if (rand == 1) {
                    getViewState().goToMain();
                }
                else if (rand == 0) {
                    getViewState().showToast(R.string.fail);
                }
            }, 2000);
        }
        else getViewState().showToast(R.string.try_again);
    }

    private boolean checkNull(String login, String password) {
        return (login.length() != 0) && (password.length() != 0);
    }

}
