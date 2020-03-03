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
import butterknife.Unbinder;

public class EntranceFragment extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.entrance)
    Button entrance;

    @BindView(R.id.registration)
    Button registration;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entrance, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        entrance.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof LoginViewFragment.LoginFragmentNavigation) {
                ((LoginViewFragment.LoginFragmentNavigation)activity).goToLoginFragment();
            }
        });

        registration.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof RegistrationViewFragment.RegistrationFragmentNavigation) {
                ((RegistrationViewFragment.RegistrationFragmentNavigation)activity).goToRegistrationFragment();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    interface EntranceFragmentNavigation {
        void goToEntranceFragment();
    }

}
