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

public class RecoveryPhoneFragment extends MvpAppCompatFragment implements RecoveryPhoneView{

    @BindView(R.id.recovery_phone)
    EditText recovery_phone;
    @BindView(R.id.recovery_phone_go)
    Button goButton;
    @BindView(R.id.recovery_phone_progress)
    ProgressBar progressBar;
    private Unbinder unbinder;

    @InjectPresenter
    RecoveryPhonePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recovery_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        goButton.setOnClickListener(v ->
                presenter.onGoClicked(recovery_phone.getText().toString()));
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
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showValidationErrors() {
        recovery_phone.setError(getString(R.string.error_empty_field));
    }

    @Override
    public void goToRecoveryCode() {
        Activity activity = getActivity();
        if (activity instanceof FragmentNavigator && activity != null){
            ((FragmentNavigator) activity).goToRecoveryCodeFragment();
        }
    }
}
