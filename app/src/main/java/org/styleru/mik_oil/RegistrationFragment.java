package org.styleru.mik_oil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationFragment extends MvpAppCompatFragment {
    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.go)
    Button goButton;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.password_repeat)
    TextView password_repeat;
    @BindView(R.id.phone_number)
    TextView phone_number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        ButterKnife.bind(this, view);
    }

    interface RegistrationFragmentNavigation {
        void goToRegistrationFragment();
    }
}
