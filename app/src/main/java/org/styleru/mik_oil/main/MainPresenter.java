package org.styleru.mik_oil.main;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import org.styleru.mik_oil.MikOilApplication;

import org.styleru.mik_oil.SharedPreferencesHelper;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    protected void onFirstViewAttach() {
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        String login  = spHelper.getLogin(context);
        if (login != null){
            getViewState().goToProfileFragment(login);
        }
        else{
            getViewState().goToEntranceFragment();
        }
    }

    protected void saveLogin(String login){
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        spHelper.setLogin(context, login);
    }
}
