package org.styleru.mik_oil.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    protected void onFirstViewAttach() {
        // DB check will be added
        getViewState().goToEntranceFragment();
    }
}
