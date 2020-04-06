package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@InjectViewState
public class CodeRecoveryPresenter extends MvpPresenter<CodeRecoveryView> {

    void onGoButtonClicked(String code) {
        Map<CodeRecoveryView.Field, Integer> errors = new HashMap<>();
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
                    String failStr = MikOilApplication.getAppContext().getString(R.string.try_again_code);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyFields(String phone, Map<CodeRecoveryView.Field, Integer> map) {
        checkEmptyField(phone, map);
    }

    private void checkEmptyField(String value,
                                 Map<CodeRecoveryView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(CodeRecoveryView.Field.CODE, R.string.error_empty_field);
        }
    }
}
