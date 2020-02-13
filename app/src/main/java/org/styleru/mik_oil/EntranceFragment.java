package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EntranceFragment extends MvpAppCompatFragment {

    //Entrance Fragment
    @BindView(R.id.EnterButton)
    Button EnterButton;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.entrance_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle saveInstanceState) {
        EnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                if (activity instanceof LoginFragment.LoginFragmentNavigation)
                    ((LoginFragment.LoginFragmentNavigation)activity).goToLoginFragment();
            }
        });
    }

    //Entrance Fragment
    interface EntranceFragmentNavigation{
        void goToEntranceFragment();
    }
}
