package org.styleru.mik_oil.splash;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import org.styleru.mik_oil.MainActivity;

public class SplashActivity extends MvpAppCompatActivity implements  SplashActivityView {

    @InjectPresenter
    SplashActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.chooseActivity();
    }

    @Override
    public void startMainPage(){

        finish();
    }

    @Override
    public void startEntrancePage(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

        finish();
    }
}
