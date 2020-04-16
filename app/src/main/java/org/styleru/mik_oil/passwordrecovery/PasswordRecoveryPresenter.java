package org.styleru.mik_oil.passwordrecovery;
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
public class PasswordRecoveryPresenter extends MvpPresenter<PasswordRecoveryView> {

    void onGetVerificationKeyClicked(String phone) {

        Map<PasswordRecoveryView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(phone, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(3);

                getViewState().setProgressEnabled(false);

                if (rand == 0) {
                    getViewState().goToCheckingVerificationKey();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyFields(String phone,
                                  Map<PasswordRecoveryView.Field, Integer> map) {
        checkEmptyField(phone, PasswordRecoveryView.Field.PHONE, map);
    }

    private void checkEmptyField(String value, PasswordRecoveryView.Field field, Map<PasswordRecoveryView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}

