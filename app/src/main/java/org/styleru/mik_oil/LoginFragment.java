package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
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

    @BindView(R.id.logEditText)
    EditText logEditText;
    @BindView(R.id.pasEditText)
    EditText pasEditText;
    @BindView(R.id.reset)
    TextView resView;
    @BindView(R.id.Sc2GoBtn)
    Button Sc2GoBtn;
    @BindView(R.id.PBSc2)
    ProgressBar PB;

    @InjectPresenter
    LoginFragmentPresenter presenter;

    interface LoginFragmentNavigator{
        void goToLoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.screen2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Sc2GoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendRequest(logEditText.getText().toString(), pasEditText.getText().toString());
            }
        });
    }

    @Override
    public void showToast(String string) {
        Toast toast = Toast.makeText(getActivity(),string, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.drawable.button);
        toast.show();
    }

    @Override
    public void Return() {
        Activity activity = getActivity();
        if (activity instanceof HomeFragment.HomeFragmentNavigator)
            ((HomeFragment.HomeFragmentNavigator)activity).goToHomeFragment();
    }


    @Override
    public void Progress(boolean isGoing) {
        if (isGoing){
            Sc2GoBtn.setVisibility(View.INVISIBLE);
            PB.setVisibility(View.VISIBLE);
        }
        else {
            PB.setVisibility(View.INVISIBLE);
        }
    }
}