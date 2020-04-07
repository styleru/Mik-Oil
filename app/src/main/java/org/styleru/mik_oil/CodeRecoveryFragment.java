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

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CodeRecoveryFragment  extends MvpAppCompatFragment implements CodeRecoveryView {

    @BindView(R.id.code_recovery_progressbar)
    ProgressBar progressBar;
    @BindView(R.id.code_recovery_go_button)
    Button goButton;
    @BindView(R.id.code_recovery)
    EditText code;

    private Unbinder unbinder;

    @InjectPresenter
    CodeRecoveryPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_code_recovery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        goButton.setOnClickListener(v -> presenter.onGoButtonClicked(code.getText().toString()));
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
        for (Map.Entry<CodeRecoveryView.Field, Integer> error : errors.entrySet()) {
            EditText field = null;
            if (error.getKey() == Field.CODE) {
                field = code;
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
