package org.styleru.mik_oil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import org.styleru.mik_oil.R;


public class MainActivity extends FragmentActivity implements Fragment_2.Fragment_2_Navigation
{// extends Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_title);

        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() == 0){
            Fragment_1 fragment_1 = new Fragment_1();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment_1).commit();
        }

    }

    @Override
    public void goToFragment_2(){

        Fragment_2 fragment_2 = new Fragment_2();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment_2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
