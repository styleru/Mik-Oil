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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    interface LoginFragmentNavigation{
        void goToLoginFragment();
    }

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
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        goButton.setVisibility(View.VISIBLE);
        goButton.setOnClickListener(v ->
                presenter.onLoginClicked(login.getText().toString(),
                                         password.getText().toString()));
        SpannableString spannableString =
                new SpannableString("Восстановить");
        spannableString.setSpan(new UnderlineSpan(),0, recovery.getText().length(),0);
        recovery.setText(spannableString);
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
    public void showToast(int check) {
        switch (check) {
            case 1: {
                Toast toast = Toast.makeText(getActivity(),
                        "Успешно", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case 0: {
                Toast toast = Toast.makeText(getActivity(),
                        "Что-то пошло не так", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case 3: {
                Toast toast = Toast.makeText(getActivity(),
                        "Заполните все поля", Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
        }
    }

    @Override
    public void goToMain() {
        Activity activity = getActivity();
        if (activity instanceof EntranceFragment.EntranceFragmentNavigation)
            ((EntranceFragment.EntranceFragmentNavigation)activity).goToEntranceFragment();
    }
}