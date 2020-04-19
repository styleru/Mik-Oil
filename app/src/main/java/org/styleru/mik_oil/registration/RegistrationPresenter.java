package org.styleru.mik_oil.registration;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.mik_oil.MikOilApplication;
import org.styleru.mik_oil.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    void onRegistrationClicked(String name, String phone,
                               String password, String repeatingPassword) {

        Map<RegistrationView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(name, phone, password, repeatingPassword, errors);
        checkPasswordsEqual(password, repeatingPassword, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(5);

                getViewState().setProgressEnabled(false);

                if (rand == 0) {
                    getViewState().goToMain();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyFields(String name, String phone,
                                  String password, String repeatingPassword,
                                  Map<RegistrationView.Field, Integer> map) {
        checkEmptyField(name, RegistrationView.Field.NAME, map);
        checkEmptyField(phone, RegistrationView.Field.PHONE, map);
        checkEmptyField(password, RegistrationView.Field.PASSWORD, map);
        checkEmptyField(repeatingPassword, RegistrationView.Field.REPEATING_PASSWORD, map);
    }

    private void checkEmptyField(String value, RegistrationView.Field field, Map<RegistrationView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }

    private void checkPasswordsEqual(String password, String repeatingPassword, Map<RegistrationView.Field, Integer> map) {
        if (password != null && !password.equals(repeatingPassword)) {
            map.put(RegistrationView.Field.REPEATING_PASSWORD, R.string.error_passwords_not_equal);
        }
    }
}
