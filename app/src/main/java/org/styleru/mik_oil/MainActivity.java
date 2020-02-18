package org.styleru.mik_oil;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements EntranceFragment.EntranceFragmentNavigation, LoginFragment.LoginFragmentNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);  // Actual Layout Name
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
                R.layout.toolbar); // Layoutname of Title Text

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            goToEntranceFragment();
        }
    }

    @Override
    public void goToEntranceFragment(){
        EntranceFragment fragment = new EntranceFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                // don't add to backstack initial fragment,
                // cause you may face a blank screen
                //TODO check whether it's initial, unless add to backstack
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
