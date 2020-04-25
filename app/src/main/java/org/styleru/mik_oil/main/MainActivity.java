package org.styleru.mik_oil.main;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import org.styleru.mik_oil.R;
import org.styleru.mik_oil.entranceScreen.EntranceFragment;
import org.styleru.mik_oil.loginScreen.LoginFragment;
import org.styleru.mik_oil.passwordRecoveryScreen.PasswordRecoveryFragment;
import org.styleru.mik_oil.registrationScreen.RegistrationFragment;
import org.styleru.mik_oil.verificationKeyScreen.VerificationKeyFragment;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void clearBackStack() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            while (count > 0) {
                getSupportFragmentManager().popBackStack();
                count--;
            }
        }
    }
}
