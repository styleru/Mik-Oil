package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EntranceFragment extends Fragment {
    @BindView(R.id.enter)
    Button enter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_entrance, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle saveInstanceState) {
        ButterKnife.bind(this, view);

        enter.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof LoginFragment.LoginFragmentNavigation)
                ((LoginFragment.LoginFragmentNavigation)activity).goToLoginFragment();
        });
    }

    interface EntranceFragmentNavigation{
        void goToEntranceFragment();
    }

}
