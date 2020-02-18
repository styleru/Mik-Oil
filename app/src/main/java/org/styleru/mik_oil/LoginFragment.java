package org.styleru.mik_oil;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
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

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    @InjectPresenter
    LoginPresenter presenter;

    @BindView(R.id.LoginEditText)
    EditText LoginEditText;
    @BindView(R.id.PasswordEditText)
    EditText PasswordEditText;
    @BindView(R.id.RecoveryLink)
    TextView RecoveryLink;
    @BindView(R.id.GoButton)
    Button GoButton;
    @BindView(R.id.ProgressBar)
    ProgressBar circularProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        //underline recovery button
        RecoveryLink.setPaintFlags(RecoveryLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        GoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imitateRequest();
            }
        });
        LoginEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                    LoginEditText.setCursorVisible(hasFocus);
            }
        });
        PasswordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                PasswordEditText.setCursorVisible(hasFocus);
            }
        });
    }

    @Override
    public void imitateRequest(){
        presenter.showProgressBar();
    }

    @Override
    public void changeVisibility(boolean isVisible){
        int changedProgressBarVisibility, changedButtonVisibility;

        if (isVisible) {
            changedProgressBarVisibility = View.VISIBLE;
            changedButtonVisibility = View.GONE;
        } else {
            changedProgressBarVisibility = View.GONE;
            changedButtonVisibility = View.VISIBLE;
        }

        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    circularProgressBar.setVisibility(changedProgressBarVisibility);
                    GoButton.setVisibility(changedButtonVisibility);
                }
            });
        }
    }

    @Override
    public void increaseProgress(){
        int progress = circularProgressBar.getProgress();
        circularProgressBar.setProgress(++progress);
    }

    @Override
    public void showToast(String toast_text){
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(activity, toast_text, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 50);
                    toast.show();
                }
            });
        }
        closeFragment();
    }

    private void closeFragment(){
        Activity activity = getActivity();
        if (activity instanceof EntranceFragment.EntranceFragmentNavigation)
            ((EntranceFragment.EntranceFragmentNavigation)activity).goToEntranceFragment();
    }

    //Login Fragment
    interface LoginFragmentNavigation{
        void goToLoginFragment();
    }
}
