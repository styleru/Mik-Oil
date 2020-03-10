package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {
   void onRegistrationClicked(String name, String phone, String password, String passwordRepeat) {
            if (checkNull(name, phone, password, passwordRepeat)) {
                if (checkPassword(password, passwordRepeat)) {
                    Handler handler = new Handler(Looper.getMainLooper());

                    getViewState().setProgressEnabled(true);
                    handler.postDelayed(() -> {
                        Random randInt = new Random();
                        int rand = randInt.nextInt(5);

                        getViewState().setProgressEnabled(false);

                        if (rand == 1) {
                            getViewState().goToMain();
                        } else if (rand > 0) {
                            String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                            getViewState().showToast(failStr);
                        }
                    }, 2000);
                } else {
                    getViewState().showRegistrationError(RegistrationView.Field.ALL, R.string.passwords_error);
                }
            } else getViewState().showRegistrationError(RegistrationView.Field.ALL, R.string.try_again);
        }

        private boolean checkNull(String name, String phone, String password, String passwordRepeat) {
            return !(name.isEmpty()) && !(phone.isEmpty()) && !(password.isEmpty()) && !(passwordRepeat.isEmpty());
        }

        private boolean checkPassword(String password, String passwordRepeat) {
            return password.equals(passwordRepeat);
        }

}
