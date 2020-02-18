package org.styleru.mik_oil;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;


@InjectViewState
public class Screen2Presenter extends MvpPresenter<Screen2View> {

    void sendRequest(final String login, final String password){

        Handler handler = new Handler();

        getViewState().Progress(true);
        handler.postDelayed(() -> {

            getViewState().Progress(false);
            getViewState().Return();

            getViewState().showToast(toastString(login, password));
        }, 2000);

    }

    private String toastString(String login, String password){
        if (login.equals("") || password.equals("")){
            return "Whyever don't ya enter anything?"; // Make this work with string.xml
        }
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1){
            return "Not today, bro(, work is still in progress"; // Make this work with string.xml
        }
        return "Maybe you should REMEMBER ALL YOUR PASSSWORDS???"; // Make this work with string.xml
    }


}