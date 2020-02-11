package org.styleru.mik_oil;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        setFragment1(fragmentManager);
    }
    public static void setFragment1(FragmentManager fragmentManager) {
        FragmentAndroid1 fragment = new FragmentAndroid1();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "1");
        fragmentTransaction.commit();
    }

    public static void setFragment2(FragmentManager fragmentManager) {
        FragmentAndroid2 fragment = new FragmentAndroid2();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "2");
        fragmentTransaction.addToBackStack("2");
        fragmentTransaction.commit();
    }

    public void findView() {
        //
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);

        if (currentFragment.getTag().equals("2"))
            setFragment1(fragmentManager);
        else
        if (currentFragment.getTag().equals("1"))
            finish();
    }

}
