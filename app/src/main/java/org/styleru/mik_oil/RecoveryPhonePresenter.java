package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Map;
import java.util.Random;

@InjectViewState
public class RecoveryPhonePresenter extends MvpPresenter<RecoveryPhoneView> {

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
                    getViewState().goToRecoveryCode();
                } else {
                    String failStr = MikOilApplication.getAppContext().getString(R.string.fail);
                    getViewState().showToast(failStr);
                }
            }, 2000);
        }
    }



    private boolean checkEmptyField(String phone) {
        if (phone == null || phone.isEmpty()) {
            return true;
        }
        return false;
    }
}
