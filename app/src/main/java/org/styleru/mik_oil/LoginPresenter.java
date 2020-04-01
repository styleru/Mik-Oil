package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    void onLoginClicked(String login, String password) {

        Map<LoginView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(login, password, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().setProgressEnabled(false);

                if (rand == 1) {
                    getViewState().goToMain();
                } else if (rand == 0) {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else getViewState().showValidationErrors(errors);
    }

    private boolean isNotNull(String login, String password) {
        return !login.isEmpty() && !password.isEmpty();
    }

    private void checkEmptyFields(String login, String password,
                                  Map<LoginView.Field, Integer> map) {
        checkEmptyField(login, LoginView.Field.LOGIN, map);
        checkEmptyField(password, LoginView.Field.PASSWORD, map);
    }

    private void checkEmptyField(String value, LoginView.Field field,
                                 Map<LoginView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}
