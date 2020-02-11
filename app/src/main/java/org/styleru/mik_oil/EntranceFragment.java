package org.styleru.mik_oil;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EntranceFragment extends Fragment {

    @BindView(R.id.enter)
    Button enter;

    private void EntranceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entrance_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle saveInstanceState) {
        enter.setOnClickListener(v -> MainActivity.setLoginFragment(MainActivity.fragmentManager));
    }
}