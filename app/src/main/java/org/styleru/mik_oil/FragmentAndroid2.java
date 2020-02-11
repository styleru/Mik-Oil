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

public class FragmentAndroid2 extends Fragment implements StdView {

    public void onAttach(MainActivity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_android_2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        final ProgressBar progressBar = view.findViewById(R.id.progress_circular);
        final Button goButton = view.findViewById(R.id.go);
        final EditText login = view.findViewById(R.id.login);
        final EditText password = view.findViewById(R.id.password);
        final Handler handler = new Handler();


        goButton.setVisibility(View.VISIBLE);

        goButton.setOnClickListener(v -> {
            if (checkNull(login, password)) {
                goButton.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(() -> {
                    Random randInt = new Random();
                    int rand = randInt.nextInt(2);

                    progressBar.setVisibility(View.INVISIBLE);
                    MainActivity.setFragment1(MainActivity.fragmentAndroid1, MainActivity.fragmentManager);

                    if (rand == 1) {
                        Toast toast = Toast.makeText(getActivity(),
                                "Ну успешно и успешно!", Toast.LENGTH_LONG);
                        toast.show();
                        login.setText("");
                        password.setText("");
                    } else {
                        Toast toast = Toast.makeText(getActivity(),
                                "Ну провал и провал!", Toast.LENGTH_LONG);
                        toast.show();
                        login.setText("");
                        password.setText("");
                    }

                }, 2000);
            } else {
                Toast toast = Toast.makeText(getActivity(),
                        "Mach noch ein Mal", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public boolean checkNull(EditText login, EditText password) {
        return (login.getText().length() != 0) && (password.getText().length() != 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}