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

    private void EntranceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entrance_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle saveInstanceState) {
        enter.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof LoginFragment.LoginFragmentNavigation)
                ((LoginFragment.LoginFragmentNavigation)activity).goToLoginFragment();
        });
    }

    interface EntranceFragmentNavigation{
        void goToEntranceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
