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
import androidx.fragment.app.Fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecoverySmsFragment extends Fragment implements RecoverySmsView  {

    @BindView(R.id.recovery_code)
    EditText code;
    @BindView(R.id.recovery_sms_go)
    Button goButton;
    @BindView(R.id.recovery_sms_progressbar)
    ProgressBar progressBar;

    @InjectPresenter
    RecoverySmsPresenter presenter;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recovery_sms, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);
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
    public void showValidationErrors(Map<RecoverySmsView.Field, Integer> errors) {
        for (Map.Entry<RecoverySmsView.Field, Integer> error : errors.entrySet()) {
            EditText field = null;
            switch (error.getKey()) {
                case CODE:
                    field = code;
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