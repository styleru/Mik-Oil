package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState

public class PhoneRecoveryPresenter extends MvpPresenter<PhoneRecoveryView> {

    void onGoButtonClicked(String phone) {
        Map<PhoneRecoveryView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(phone, errors);
        if (errors.isEmpty()){
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().setProgressEnabled(false);

                if (rand == 1) {
                    getViewState().goToCodeRecoveryFragment();
                } else if (rand == 0) {
                    String fail = MikOilApplication.getAppContext().getString(R.string.try_again_phone);
                    getViewState().showToast(fail);
                }
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }

    }

    private void checkEmptyFields(String phone, Map<PhoneRecoveryView.Field, Integer> map) {
        checkEmptyField(phone, PhoneRecoveryView.Field.PHONE, map);
    }

    private void checkEmptyField(String value, PhoneRecoveryView.Field field,
                                 Map<PhoneRecoveryView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}
