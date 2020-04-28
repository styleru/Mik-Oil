package org.styleru.mik_oil.splash;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import org.styleru.mik_oil.main.MainActivity;

public class SplashActivity extends MvpAppCompatActivity implements  SplashActivityView {

    public static String AUTH_INDICATOR = "is client authorized?";

    @InjectPresenter
    SplashActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.chooseFragment();
    }

    @Override
    public void startMainFragment(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(AUTH_INDICATOR, true);
        startActivity(intent);

        finish();
    }

    @Override
    public void startEntranceFragment(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(AUTH_INDICATOR, false);
        startActivity(intent);

        finish();
    }
}
