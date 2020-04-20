package org.styleru.mik_oil.splash;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashActivityPresenter extends MvpPresenter<SplashActivityView> {

    void chooseFragment(){
        if(true == true){
            getViewState().startEntranceFragment();
        }
        else {
            getViewState().startMainFragment();
        }
    }
}
