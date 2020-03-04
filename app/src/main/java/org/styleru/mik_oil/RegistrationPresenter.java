package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    void onRegisterClicked(String userName, String userPhoneNumber, String userPassword, String userRepeatPassword) {
        if (isFieldsNotEmpty(userName, userPhoneNumber, userPassword, userRepeatPassword)) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(10);

                getViewState().setProgressEnabled(false);

                if (rand <= 1) {
                    getViewState().goToPhoneNumberChecking();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.registration_fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else getViewState().showValidationError(RegistrationView.Field.ALL, R.string.empty_fields);
    }

    private boolean isFieldsNotEmpty(String userName, String userPhoneNumber, String userPassword, String userRepeatPassword) {
        return !(userName.isEmpty()) && !(userPhoneNumber.isEmpty()) && !(userPassword.isEmpty()) && !(userRepeatPassword.isEmpty());
    }
}

