package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    void onRegisterClicked(String name, String phoneNumber, String password, String repeatPassword) {
        if (isFieldsNotEmpty(name, phoneNumber, password, repeatPassword)) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(5);

                getViewState().setProgressEnabled(false);

                if (rand == 1) {
                    getViewState().goToMain();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.registration_fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else {
            getViewState().showValidationError(RegistrationView.Field.ALL, R.string.empty_fields);
        }
    }

    private boolean isFieldsNotEmpty(String name, String phoneNumber, String password, String repeatPassword) {
        if (name != null && phoneNumber != null && password != null && repeatPassword != null)
        {
            return !(name.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || repeatPassword.isEmpty());
        } else {
            return false;
        }
    }

}

