package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.reg_button)
    Button regButton;
    @BindView(R.id.enter_button)
    Button enterButton;

    interface HomeFragmentNavigator{
        void goToHomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        enterButton.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof LoginFragment.LoginFragmentNavigator)
                ((LoginFragment.LoginFragmentNavigator)activity).goToLoginFragment();
        });

        regButton.setEnabled(false);
    }
}