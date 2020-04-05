package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState
public class RecoveryCodePresenter extends MvpPresenter<RecoveryCodeView> {

    void onGoClicked(String code) {
        Map<RecoveryCodeView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(code, errors);
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

    private void checkEmptyFields(String phone, Map<RecoveryCodeView.Field, Integer> map) {
        checkEmptyField(phone, RecoveryCodeView.Field.CODE, map);
    }

    private void checkEmptyField(String value, RecoveryCodeView.Field field,
                                 Map<RecoveryCodeView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}
