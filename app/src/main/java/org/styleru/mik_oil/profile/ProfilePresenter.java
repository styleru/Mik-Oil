package org.styleru.mik_oil.profile;

import android.content.Context;

import com.arellomobile.mvp.MvpPresenter;

import org.styleru.mik_oil.SharedPreferencesHelper;

import org.styleru.mik_oil.MikOilApplication;

public class ProfilePresenter extends MvpPresenter<ProfileView> {
    public void makeLogout(){
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        spHelper.setLogin(context, null);
    }
}
