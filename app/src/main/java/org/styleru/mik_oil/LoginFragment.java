package org.styleru.mik_oil;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.go)
    Button goButton;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.recovery)
    TextView recovery;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.login_fragmnet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        ButterKnife.bind(this, view);

        SpannableString spannableString =
                new SpannableString(recovery.getText());
        spannableString.setSpan(new UnderlineSpan(),0, recovery.getText().length(),0);
        recovery.setText(spannableString);
        goButton.setOnClickListener(v ->
                presenter.onLoginClicked(login.getText().toString(),
                        password.getText().toString()));
    }

    interface LoginFragmentNavigation{
        void goToLoginFragment();
    }

    @Override
    public void setProgressEnabled(boolean enabled) {
        if (enabled)
        {
            goButton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }
        else {
            progressBar.setVisibility(View.INVISIBLE);
            goButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showToast(int check) {
            Toast toast = Toast.makeText(getActivity(),
                    check, Toast.LENGTH_SHORT);
            toast.show();
    }

    @Override
    public void showAuthError(int message) {
        Toast toast = Toast.makeText(getActivity(),
                message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void goToMain() {
        showToast(R.string.luck);
    }
}