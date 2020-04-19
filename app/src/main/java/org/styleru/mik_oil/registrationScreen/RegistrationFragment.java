package org.styleru.mik_oil.registrationScreen;

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

import org.styleru.mik_oil.R;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegistrationFragment extends MvpAppCompatFragment implements RegistrationView {

    @BindView(R.id.registration_progressbar)
    ProgressBar progressBar;
    @BindView(R.id.registration_go_button)
    Button goButton;
    @BindView(R.id.registration_name)
    EditText name;
    @BindView(R.id.registration_phone_number)
    EditText phone;
    @BindView(R.id.registration_password)
    EditText password;
    @BindView(R.id.registration_repeat_password)
    EditText repeatingPassword;

    private Unbinder unbinder;

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
                presenter.onRegistrationClicked(name.getText().toString(),
                        phone.getText().toString(), password.getText().toString(),
                        repeatingPassword.getText().toString()));
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void setProgressEnabled(boolean enabled) {
        if (enabled) {
            goButton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            goButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showValidationErrors(Map<Field, Integer> errors) {
        for (Map.Entry<Field, Integer> error : errors.entrySet()) {
            EditText field = null;
            switch (error.getKey()) {
                case NAME:
                    field = name;
                    break;
                case PHONE:
                    field = phone;
                    break;
                case PASSWORD:
                    field = password;
                    break;
                case REPEATING_PASSWORD:
                    field = repeatingPassword;
                    break;
            }
            if (field != null) {
                field.setError(getString(error.getValue()));
            }
        }
    }

    @Override
    public void goToMain() {
        String message = getString(R.string.success);
        showToast(message);
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
