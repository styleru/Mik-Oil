package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    void onRegistrationClicked(String name, String phone,
                               String password, String repeatingPassword) {
        if (isNotNull(name, phone, password, repeatingPassword)) {
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
        } else getViewState().showValidationError(RegistrationView.Field.ALL,
                R.string.try_again);
    }

    private boolean isNotNull(String name, String phone,
                              String password, String repeatingPassword) {
        return !(name.isEmpty()) && !(phone.isEmpty()) &&
                !(password.isEmpty()) && !(repeatingPassword.isEmpty());
    }
}
