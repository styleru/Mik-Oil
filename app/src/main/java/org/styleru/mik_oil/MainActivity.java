package org.styleru.mik_oil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements EntranceFragment.EntranceFragmentNavigation, LoginFragment.LoginFragmentNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToEntranceFragment();
    }

    @Override
    public void goToEntranceFragment(){
        EntranceFragment fragment = new EntranceFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToLoginFragment(){
        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
