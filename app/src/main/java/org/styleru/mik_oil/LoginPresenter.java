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
                getViewState().goToMain();

                if (rand == 1)
                    getViewState().setToast("Успех");
                else if (rand == 0) getViewState().setToast("Провал");
            }, 2000);
        }
        else getViewState().setToast("Попробуй еще раз");
    }

    private boolean checkNull(String login, String password) {
        return (login.length() != 0) && (password.length() != 0);
    }

}
