package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RecoveryPresenter extends MvpPresenter<RecoveryView> {

    void onRecoveryClicked(String phone) {

        Map<RecoveryView.Field, Integer> errors = new HashMap<>();
        checkEmptyField(phone, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(5);

                getViewState().setProgressEnabled(false);

                getViewState().goToRecoverySms();
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyField(String value, Map<RecoveryView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(RecoveryView.Field.PHONE, R.string.error_empty_field);
        }
    }
}
