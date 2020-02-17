package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    //extends MvpAppCompatFragment
    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.go)
    Button goButton;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.recovery)
    Button recovery;

    @InjectPresenter
    LoginPresenter presenter;

    private void LoginFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragmnet, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        ButterKnife.bind(this, view);

        goButton.setVisibility(View.VISIBLE);
        SpannableString spannableString =
                new SpannableString("Восстановить");
        spannableString.setSpan(new UnderlineSpan(),0, recovery.getText().length(),0);
        recovery.setText(spannableString);
        goButton.setOnClickListener(v ->
                presenter.onLoginClicked(login.getText().toString(),
                        password.getText().toString()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        else progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showToast(String check) {
        if (check.equals("Успех")) {
            Toast toast = Toast.makeText(getActivity(),
                    "Успех!", Toast.LENGTH_SHORT);
            toast.show();
        } else if (check.equals("Провал")) {
            Toast toast = Toast.makeText(getActivity(),
                    "Провал!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (check.equals("Попробуй еще раз")){
            Toast toast = Toast.makeText(getActivity(),
                    "Попробуйте еще раз.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void showAuthError(int message) {}

    @Override
    public void goToMain() {
        Activity activity = getActivity();
        if (activity instanceof EntranceFragment.EntranceFragmentNavigation)
            ((EntranceFragment.EntranceFragmentNavigation)activity).goToEntranceFragment();
    }
}