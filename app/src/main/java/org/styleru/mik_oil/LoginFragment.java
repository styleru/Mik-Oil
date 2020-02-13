package org.styleru.mik_oil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
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

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class LoginFragment extends MvpAppCompatFragment implements EntranceView {

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
//        setRetainInstance(true);  redundant, doesn't work with backstack
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
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
    }

    private int progressStatus = 0;
    Handler handler = new Handler();

    private void imitateRequest(){
        GoButton.setVisibility(View.INVISIBLE);
        showProgressBar();
    }

    private void showProgressBar(){
        circularProgressBar.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            circularProgressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 20 milliseconds.
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopProgressBar();
            }
        }).start();
    }

    private void stopProgressBar(){
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    circularProgressBar.setVisibility(View.INVISIBLE);
                    showToast();
                }
            });
        }
    }

    private void showToast(){
        int state = (int) round(random());
        Context context = getContext();
        if (context != null) {
            if (state == 1) {
                Toast toast = Toast.makeText(context,"Success!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 50);
                toast.show();
            } else {
                Toast toast = Toast.makeText(context,"Failed!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 50);
                toast.show();
            }
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
