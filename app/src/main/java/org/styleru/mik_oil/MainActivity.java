package org.styleru.mik_oil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        setEntranceFragment(fragmentManager);
    }

    public static void setEntranceFragment(FragmentManager fragmentManager) {
        EntranceFragment fragment = new EntranceFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "entrance");
        fragmentTransaction.commit();
    }

    public static void setLoginFragment(FragmentManager fragmentManager) {
        LoginFragment fragment = new LoginFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "login");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onBackPressed() {
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);
        if (currentFragment.getTag().equals("login"))
            setEntranceFragment(fragmentManager);
        else if (currentFragment.getTag().equals("entrance"))
            finish();
    }
}
