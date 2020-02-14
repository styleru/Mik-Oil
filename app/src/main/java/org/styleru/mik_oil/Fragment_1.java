package org.styleru.mik_oil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_1 extends Fragment {


    @BindView(R.id.android_1_2)
    Button btn_2;
    @BindView(R.id.android_1_1)
    Button btn_1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){


        View view = inflater.inflate(R.layout.android_1, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_2.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return btn_clicked(v, event);
                    }
                }
        );

        btn_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Activity activity = getActivity();
                        if (activity instanceof Fragment_2.Fragment_2_Navigation){
                            ((Fragment_2.Fragment_2_Navigation)activity).goToFragment_2();
                        }
                    }
                }
        );

        btn_1.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return btn_clicked(v, event);
                    }
                }
        );

        set_btn(btn_1);
        set_btn(btn_2);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private boolean btn_clicked(View v, MotionEvent event){
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                v.setElevation(0);
                v.setTranslationZ(0);
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                v.performClick();
                v.setElevation(10);
                v.setTranslationZ(10);
                return true;
            }
            return false;
    }
    ///123443
    private void set_btn(Button btn){
        btn.setElevation(10);
        btn.setTranslationZ(10);
    }
}
