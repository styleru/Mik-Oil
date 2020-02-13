package org.styleru.mik_oil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends MvpAppCompatFragment implements EntranceView {

    @BindView(R.id.LoginEditText)
    EditText LoginEditText;
    @BindView(R.id.PasswordEditText)
    EditText PasswordEditText;
    @BindView(R.id.RecoveryLink)
    TextView RecoveryLink;
    @BindView(R.id.GoButton)
    Button GoButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    //Login Fragment
    interface LoginFragmentNavigation{
        void goToLoginFragment();
    }
}