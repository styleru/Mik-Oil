package org.styleru.mik_oil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.andreev.bvsru.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Screen1 extends Fragment {

    @BindView(R.id.regButton)
    Button regButton;
    @BindView(R.id.entButton)
    Button entButton;

    interface Screen1Int{
        void goToScreen1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.screen1, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        entButton.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof Screen2.Screen2Int)
                ((Screen2.Screen2Int)activity).goToScreen2();
        });

        regButton.setEnabled(false);
    }
}