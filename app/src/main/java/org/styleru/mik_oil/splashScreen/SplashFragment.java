package org.styleru.mik_oil.splashScreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import org.styleru.mik_oil.FragmentNavigator;
import org.styleru.mik_oil.R;

public class SplashFragment extends MvpAppCompatFragment implements SplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        presenter.isUserRegistered();
    }

    @Override
    public void goToMain() {

    }

    @Override
    public void goToEntrance() {
        Activity activity = getActivity();
        if (activity != null) {
            ((FragmentNavigator) activity).goToEntranceFragment();
        }
    }
}
