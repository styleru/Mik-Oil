package org.styleru.mik_oil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationFragment extends MvpAppCompatFragment implements RegistrationView {

    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.go)
    Button goButton;
    @BindView(R.id.name_field)
    EditText name;
    @BindView(R.id.phone_field)
    EditText phone;
    @BindView(R.id.password_field)
    EditText password;
    @BindView(R.id.repeating_password_field)
    EditText repeatingPassword;

    @InjectPresenter
    RegistrationPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        ButterKnife.bind(this, view);
        goButton.setOnClickListener(v ->
                presenter.onRegistrationClicked(name.getText().toString(),
                        phone.getText().toString(), password.getText().toString(),
                        repeatingPassword.getText().toString()));
    }

    @Override
    public void setProgressEnabled(boolean enabled) {
        if (enabled) {
            goButton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            goButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showValidationError(RegistrationView.Field field, int messageRes) {
        String message = getString(messageRes);
        showToast(message);
    }

    @Override
    public void goToMain() {
        String message = getString(R.string.luck);
        showToast(message);
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
