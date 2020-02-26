package org.styleru.mik_oil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends MvpAppCompatFragment implements LoginFragmentView {

    @BindView(R.id.login_edit_text)
    EditText loginEditText;
    @BindView(R.id.pass_edit_text)
    EditText passEditText;
    @BindView(R.id.reset)
    TextView resetTextView;
    @BindView(R.id.login_go_btn)
    Button loginGoBtn;
    @BindView(R.id.login_progress_bar)
    ProgressBar loginProgressBar;

    @InjectPresenter
    LoginFragmentPresenter presenter;

    interface LoginFragmentNavigator{
        void goToLoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loginGoBtn.setOnClickListener(v ->  {
                Handler handler = new Handler(Looper.getMainLooper());
                presenter.sendRequest();
                handler.postDelayed(() -> {
                    presenter.showToast(loginEditText.getText().toString(), passEditText.getText().toString());
                }, 2000);
        });
    }

    @Override
    public void showToast(int a) {
        Toast toast = Toast.makeText(getActivity(), a, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.drawable.button);
        toast.show();
    }

    @Override
    public void showToast(String string) {
        Toast toast = Toast.makeText(getActivity(),string, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.drawable.button);
        toast.show();
    }

    @Override
    public void progress(boolean isGoing) {
        if (isGoing){
            loginGoBtn.setVisibility(View.INVISIBLE);
            loginGoBtn.setEnabled(false);
            loginProgressBar.setVisibility(View.VISIBLE);
        }
        else {
            loginProgressBar.setVisibility(View.INVISIBLE);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> {
                loginGoBtn.setVisibility(View.VISIBLE);
                loginGoBtn.setEnabled(true);
            }, 2000);
        }
    }


}