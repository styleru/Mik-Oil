package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState
public class RecoveryPhonePresenter extends MvpPresenter<RecoveryPhoneView> {

    void onGoClicked(String phone) {
        Map<RecoveryPhoneView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(phone, errors);
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
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyFields(String phone, Map<RecoveryPhoneView.Field, Integer> map) {
        checkEmptyField(phone, RecoveryPhoneView.Field.PHONE, map);
    }

    private void checkEmptyField(String value, RecoveryPhoneView.Field field,
                                 Map<RecoveryPhoneView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}
