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

public class FragmentEntrance extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @BindView(R.id.enter)
    Button enter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entrance, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        if (enter != null)
        {
            enter.setOnClickListener(v -> {
                Activity activity = getActivity();
                if (activity instanceof FragmentLogin.LoginFragmentNavigation)
                    ((FragmentLogin.LoginFragmentNavigation)activity).goToLoginFragment();
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    interface EntranceFragmentNavigation{
        void goToEntranceFragment();
    }
}