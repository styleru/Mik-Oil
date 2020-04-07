package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState

public class RecoveryCodePresenter extends MvpPresenter<RecoveryCodeView> {
    void onGoClicked(String Phone){
        if (checkEmptyField(Phone)){
            getViewState().showValidationErrors();
        }
        else{
            Handler handler = new Handler(Looper.getMainLooper());

            getViewState().setProgressEnabled(true);
            handler.postDelayed(() -> {
                Random randInt = new Random();
                int rand = randInt.nextInt(2);

                getViewState().setProgressEnabled(false);

                if (rand == 0) {
                    getViewState().goToMain();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        }
    }

    private boolean checkEmptyField(String code) {
        if (code == null || code.isEmpty()) {
            return true;
        }
        return false;
    }

}
