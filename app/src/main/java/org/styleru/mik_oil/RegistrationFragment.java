package org.styleru.mik_oil;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegistrationFragment extends MvpAppCompatFragment implements RegistrationView {

    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.telephone)
    EditText telephone;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.repeat_password)
    EditText repeatPassword;

    @BindView(R.id.progress_registration)
    ProgressBar progressBar;

    @BindView(R.id.go_registration)
    Button goButton;

    @InjectPresenter
    RegistrationPresenter presenter;

    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder =  ButterKnife.bind(this, view);

        goButton.setOnClickListener(v ->{
            EditText[] fieldArr = {name, telephone, password, repeatPassword};
            String[] fieldStringsArr = new String[4];
            for (int i = 0; i < 4; i++){
                fieldStringsArr[i] = fieldArr[i].getText().toString();
            }
            presenter.onGoClicked(fieldStringsArr);
        });
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
