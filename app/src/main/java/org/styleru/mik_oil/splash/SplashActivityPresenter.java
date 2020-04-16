package org.styleru.mik_oil.splash;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashActivityPresenter extends MvpPresenter<SplashActivityView> {

    void chooseActivity(){
        if(true == true){
            getViewState().startEntrancePage();
        }
        else {
            getViewState().startMainPage();
        }
    }
}
