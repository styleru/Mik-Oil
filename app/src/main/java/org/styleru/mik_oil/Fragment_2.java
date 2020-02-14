package org.styleru.mik_oil;

import android.app.Fragment;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment_2 extends MvpAppCompatFragment implements Android_2_View {


    @InjectPresenter
    Android_2_Presenter presenter;

    @BindView(R.id.android_2_4)
    Button button_4;

    @BindView(R.id.progressBar_2)
    ProgressBar progressBar;

    @BindView(R.id.android_2_3)
    TextView textView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.android_2, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onGoClicked();

            }
        });
        textView.setText(
            Html.fromHtml(
                    "<u>"+textView.getText().toString()+"</u>"
            )
        );
        button_4.setElevation(10);
        button_4.setTranslationZ(10);
        button_4.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return btn_clicked(v, event);
                    }
                }
        );

    }

    @Override
    public void SetProgressBar(boolean show){
        int visibility = show ? View.VISIBLE : View.GONE;
        progressBar.setVisibility(visibility);
        visibility = !show ? View.VISIBLE : View.GONE;
        button_4.setVisibility(visibility);
    }

    @Override
    public void ShowToast(boolean succes){
        String message = succes? getString(R.string.toast_msg_succes) : getString(R.string.toast_msg_not);
        Toast toast = Toast.makeText(getContext(),
                message, Toast.LENGTH_SHORT);
        toast.show();
    }


    interface Fragment_2_Navigation {
        void goToFragment_2();
    }

    private boolean btn_clicked(View v, MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            v.setElevation(0);
            v.setTranslationZ(0);
            return false;
        }
        if (event.getAction() == MotionEvent.ACTION_UP){
            v.setElevation(10);
            v.setTranslationZ(10);
            v.performClick();
            return true;
        }
        return false;
    }
}
