package org.styleru.mik_oil;

import android.app.Activity;
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

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecoveryPhoneFragment extends MvpAppCompatFragment implements RecoveryPhoneView {

    @BindView(R.id.recovery_phone_progressbar)
    ProgressBar progressBar;
    @BindView(R.id.recovery_phone_go_button)
    Button goButton;
    @BindView(R.id.recovery_phone)
    EditText phone;
    @InjectPresenter
    RecoveryPhonePresenter presenter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recovery_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        goButton.setOnClickListener(v -> presenter.onGoClicked(phone.getText().toString()));
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
                case PHONE:
                    field = phone;
                    break;
                case ALL:
                    String msg = getString(error.getValue());
                    showToast(msg);
            }
            if (field != null) {
                field.setError(getString(error.getValue()));
            }
        }
    }

    @Override
    public void goToRecoveryCodeFragment() {
        String message = getString(R.string.luck);
        showToast(message);
        Activity activity = getActivity();
        if (activity != null) {
            ((FragmentNavigator) activity).goToRecoveryCodeFragment();
        }
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}

