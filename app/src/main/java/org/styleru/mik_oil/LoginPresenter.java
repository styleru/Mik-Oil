package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    void onGoClicked(String login, String password) {
        if (isFieldsNotEmpty(login, password)) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().changeProgressState(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().changeProgressState(false);

                if (rand % 2 == 0) {
                    getViewState().goToMain();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.login_fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else getViewState().showValidationError(LoginView.Field.ALL, R.string.empty_fields);
    }

    private boolean isFieldsNotEmpty(String login, String password) {
        return !(login.isEmpty()) && !(password.isEmpty());
    }

}
