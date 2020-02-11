package org.styleru.mik_oil;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment {

    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.go)
    Button goButton;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;

    private void LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        Handler handler = new Handler();
        goButton.setVisibility(View.VISIBLE);
        goButton.setOnClickListener(v -> {
            if (notEmpty(login, password)) {
                goButton.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(() -> {
                    Random randInt = new Random();
                    int rand = randInt.nextInt(2);

                    progressBar.setVisibility(View.INVISIBLE);
                    MainActivity.setEntranceFragment(MainActivity.fragmentManager);
                    if (rand == 1) {
                        Toast toast = Toast.makeText(getActivity(),
                                "Успешно", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getActivity(),
                                "Неудачно", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }, 2000);
            } else {
                Toast toast = Toast.makeText(getActivity(),
                        "Введите логин и пароль", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public boolean notEmpty(EditText login, EditText password) {
        return (login.getText().length() != 0) && (password.getText().length() != 0);
    }
}
