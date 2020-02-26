package org.styleru.mik_oil;

import android.os.Handler;
import android.os.Looper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;


@InjectViewState
public class LoginFragmentPresenter extends MvpPresenter<LoginFragmentView> {

    void sendRequest(final String login, final String password){
        if (login.equals("") || password.equals("")){
            showToast(login, password);
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            getViewState().progress(true);
            handler.postDelayed(() -> {
                getViewState().progress(false);
            }, 2000);
        }
    }

    void showToast(final String login, final String password){
        getViewState().showToast(passAndLoginCheck(login, password));
    }

    void showToast(String string){
        getViewState().showToast(string);
    }


    private int passAndLoginCheck(String login, String password){

        if (login.equals("") || password.equals("")){
            return R.string.text_for_toast_empty;
        }
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1){
            return R.string.text_for_toast_success;
        }
        return R.string.text_for_toast_failure;
    }

}
