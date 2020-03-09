package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    void onGoClicked(String[] registration_data) {
        if (checkNull(registration_data)) {
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
            String failStr =  MikOilApplication.getAppContext().getString(R.string.try_again);
            RegistrationView v = getViewState();
            getViewState().showToast(failStr);
        }
    }
    boolean checkNull(String[] registration_data){
        boolean isNull = true;
        for (String s: registration_data) {
            isNull = isNull && !(s.isEmpty());
        }
        return isNull;
    }

}
