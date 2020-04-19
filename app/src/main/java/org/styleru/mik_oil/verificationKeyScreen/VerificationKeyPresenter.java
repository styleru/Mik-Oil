package org.styleru.mik_oil.verificationKeyScreen;

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
public class VerificationKeyPresenter extends MvpPresenter<VerificationKeyView> {

    void onCheckVerificationKeyClicked(String verificationKey) {

        Map<VerificationKeyView.Field, Integer> errors = new HashMap<>();
        checkEmptyFields(verificationKey, errors);
        if (errors.isEmpty()) {
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(5);

                getViewState().setProgressEnabled(false);

                if (rand == 0) {
                    getViewState().goToMain();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        } else {
            getViewState().showValidationErrors(errors);
        }
    }

    private void checkEmptyFields(String verificationKey,
                                  Map<VerificationKeyView.Field, Integer> map) {
        checkEmptyField(verificationKey, VerificationKeyView.Field.VERIFICATION_KEY, map);
    }

    private void checkEmptyField(String value, VerificationKeyView.Field field, Map<VerificationKeyView.Field, Integer> map) {
        if (value == null || value.isEmpty()) {
            map.put(field, R.string.error_empty_field);
        }
    }
}
