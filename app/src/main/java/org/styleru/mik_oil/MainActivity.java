package org.styleru.mik_oil;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.styleru.mik_oil.entrance.EntranceFragment;
import org.styleru.mik_oil.login.LoginFragment;
import org.styleru.mik_oil.password_recovery.PasswordRecoveryFragment;
import org.styleru.mik_oil.registration.RegistrationFragment;
import org.styleru.mik_oil.verification_key.VerificationKeyFragment;

import static org.styleru.mik_oil.splash.SplashActivity.AUTH_INDICATOR;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        boolean isAuthorized = intent.getBooleanExtra(AUTH_INDICATOR, false);

        if (isAuthorized) {
            // goToMainFragment();
        }
        else {
            goToEntranceFragment();
        }
    }

    @Override
    public void goToLoginFragment() {
        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToEntranceFragment() {
        clearBackStack();
        EntranceFragment fragment = new EntranceFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void goToPasswordRecoveryFragment() {
        PasswordRecoveryFragment fragment = new PasswordRecoveryFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToVerificationKeyFragment() {
        VerificationKeyFragment fragment = new VerificationKeyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToRegistrationFragment() {
        RegistrationFragment fragment = new RegistrationFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void clearBackStack(){
        int count = getSupportFragmentManager().getBackStackEntryCount();
        while (count > 0) {
            getSupportFragmentManager().popBackStack();
            count--;
        }
    }
}
