package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.victor.loading.rotate.RotateLoading;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentLogin extends MvpAppCompatFragment implements ViewLogin {

    private Unbinder unbinder;

    @Nullable @BindView(R.id.login)
    EditText login;

    @Nullable @BindView(R.id.password)
    EditText password;

    @Nullable @BindView(R.id.recovery)
    TextView recovery;

    @Nullable @BindView(R.id.progress)
    RotateLoading progress;

    @Nullable @BindView(R.id.go)
    TextView go;

    @InjectPresenter
    PresenterLogin presenter;

     private FragmentLogin() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        if(go != null)
        {
            go.setOnClickListener(v -> {
                if (password != null) {
                    if (login != null) {
                        presenter.sendingRequest(login.getText().toString(),
                                password.getText().toString());
                    }
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void changeProgressState(boolean processing) {
        if (processing)
        {
            if (go != null) {
                go.setVisibility(View.INVISIBLE);
            }
            if (progress != null) {
                progress.start();
            }
        }
        else {
            if (progress != null) {
                progress.stop();
            }
            if (go != null) {
                go.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getActivity(),
                text, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void goToEntrance() {
        Activity activity = getActivity();
        if (activity instanceof FragmentEntrance.EntranceFragmentNavigation)
            ((FragmentEntrance.EntranceFragmentNavigation)activity).goToEntranceFragment();
    }

    interface LoginFragmentNavigation{
        void goToLoginFragment();
    }
}