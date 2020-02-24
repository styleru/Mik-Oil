package org.styleru.mik_oil;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;


@InjectViewState
public class LoginFragmentPresenter extends MvpPresenter<LoginFragmentView> {

    void sendRequest(){

        Handler handler = new Handler();

        getViewState().progress(true);
        handler.postDelayed(() -> {

            getViewState().progress(false);
        }, 2000);
    }

    void showToast(final String login, final String password){
        getViewState().showToast(passAndLoginCheck(login, password));
    }

    void resetFragment(){
        getViewState().resetFragment();
    }

    private String passAndLoginCheck(String login, String password){

        if (login.equals("") || password.equals("")){
            return "Whyever don't ya enter anything?"; // Make this work with string.xml
        }
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1){
            return "Not today, bro(, work is still in progress"; // Make this work with string.xml
        }
        return "Maybe you should REMEMBER ALL YOUR PASSWORDS???"; // Make this work with string.xml
    }


}