package org.styleru.mik_oil;


import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;


@InjectViewState
public class Android_2_Presenter extends MvpPresenter<Android_2_View>
{
    private int counter = 0;
    Random random = new Random();
    void onGoClicked(){
        getViewState().SetProgressBar(true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getViewState().SetProgressBar(false);
                boolean success = random.nextBoolean();
                getViewState().ShowToast(success);
            }
        }, 2000);

    }
}
