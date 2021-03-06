package org.styleru.mik_oil.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import org.styleru.mik_oil.R;
import org.styleru.mik_oil.navigation.FragmentNavigator;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    @BindView(R.id.login_progressbar)
    ProgressBar progressBar;
    @BindView(R.id.login_go)
    Button goButton;
    @BindView(R.id.login_login)
    EditText login;
    @BindView(R.id.login_password)
    EditText password;
    @BindView(R.id.login_recovery)
    TextView recovery;

    private Unbinder unbinder;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        SpannableString spannableString = new SpannableString(recovery.getText());
        spannableString.setSpan(new UnderlineSpan(), 0, recovery.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        recovery.setText(spannableString);
        recovery.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity != null) {
                ((FragmentNavigator) activity).goToPasswordRecoveryFragment();
            }
        });

        goButton.setOnClickListener(v ->
                presenter.onLoginClicked(login.getText().toString(),
                        password.getText().toString()));
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
    public void showValidationErrors(Map<Field, Integer> errors) {
        for (Map.Entry<Field, Integer> error : errors.entrySet()) {
            EditText field = null;
            switch (error.getKey()) {
                case LOGIN:
                    field = login;
                    break;
                case PASSWORD:
                    field = password;
                    break;
            }
            if (field != null) {
                field.setError(getString(error.getValue()));
            }
        }
    }

    @Override
    public void goToProfile() {
        Activity activity = getActivity();
        if (activity != null) {
            ((FragmentNavigator) activity).goToProfileFragment();
        }
    }
}