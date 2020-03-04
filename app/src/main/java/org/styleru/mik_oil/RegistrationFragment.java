package org.styleru.mik_oil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegistrationFragment extends MvpAppCompatFragment implements RegistrationView {

    private Unbinder unbinder;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.goButton)
    Button goButton;

    @BindView(R.id.userName)
    EditText userName;

    @BindView(R.id.userPhoneNumber)
    EditText userPhoneNumber;

    @BindView(R.id.userPassword)
    TextView userPassword;

    @BindView(R.id.userRepeatPassword)
    TextView userRepeatPassword;

    @InjectPresenter
    RegistrationPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        goButton.setOnClickListener(v ->
                presenter.onRegisterClicked(userName.getText().toString(),
                        userPhoneNumber.getText().toString(),
                        userPassword.getText().toString(),
                        userRepeatPassword.getText().toString()));
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
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(),
                text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showValidationError(Field field, @StringRes int messageRes) {
        String message = getString(messageRes);
        showToast(message);
    }

    @Override
    public void goToPhoneNumberChecking() {
        String message = getString(R.string.go_to_phone_number_checking);
        showToast(message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
