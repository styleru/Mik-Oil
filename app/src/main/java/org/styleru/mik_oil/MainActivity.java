package org.styleru.mik_oil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentEntrance.EntranceFragmentNavigation,
        FragmentLogin.LoginFragmentNavigation {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            goToEntranceFragment();
        }
    }

    @Override
    public void goToLoginFragment(){
        FragmentLogin fragment = new FragmentLogin();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void goToEntranceFragment(){
        FragmentEntrance fragment = new FragmentEntrance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
