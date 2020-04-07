package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;

public class RecoverySmsPresenter extends MvpPresenter<RecoverySmsView> {

    void onRecoveryClicked(String code) {

        Map<RecoverySmsView.Field, Integer> errors = new HashMap<>();
        checkEmptyField(code, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                getViewState().setProgressEnabled(false);
                getViewState().goToMain();
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyField(String value, Map<RecoverySmsView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(RecoverySmsView.Field.CODE, R.string.error_empty_field);
        }
    }

}
