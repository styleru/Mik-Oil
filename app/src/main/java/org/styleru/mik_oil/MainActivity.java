package org.styleru.mik_oil;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;
    static androidx.fragment.app.FragmentManager fragmentManagerCheck;
    static FragmentAndroid1 fragmentAndroid1;
    static FragmentAndroid2 fragmentAndroid2;

    public static void setFragment1(FragmentAndroid1 fragment1, FragmentManager fragmentManager) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment1, "1");
        fragmentTransaction.commit();
    }

    public static void setFragment2(FragmentAndroid2 fragment2, FragmentManager fragmentManager) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment2, "2");
        fragmentTransaction.addToBackStack("2");
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setFragment1(fragmentAndroid1, fragmentManager);
    }

    public void findView() {
        fragmentManager = getFragmentManager();
        fragmentAndroid1 = new FragmentAndroid1();
        fragmentAndroid2 = new FragmentAndroid2();
    }

    @Override
    public void onBackPressed() {
        fragmentManagerCheck = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);

        if (currentFragment.getTag().equals("2")) {
            setFragment1(fragmentAndroid1, fragmentManager);
        } else if (currentFragment.getTag().equals("1")) {
            finish();
        }
    }

}
