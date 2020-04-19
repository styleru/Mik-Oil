package org.styleru.mik_oil.entrance;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.styleru.mik_oil.R;
import org.styleru.mik_oil.navigation.FragmentNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EntranceFragment extends Fragment {
    @BindView(R.id.entrance_login)
    Button login;
    @BindView(R.id.entrance_registration)
    Button registration;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entrance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        login.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity != null) {
                ((FragmentNavigator) activity).goToLoginFragment();
            }
        });
        registration.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity != null) {
                ((FragmentNavigator) activity).goToRegistrationFragment();
            }
        });
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
