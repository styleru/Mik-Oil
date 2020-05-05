package org.styleru.mik_oil.profile;

import android.content.Context;

import com.arellomobile.mvp.MvpPresenter;

import org.styleru.mik_oil.SharedPreferencesHelper;

import org.styleru.mik_oil.MikOilApplication;

import java.text.DecimalFormat;
import java.util.Random;

public class ProfilePresenter extends MvpPresenter<ProfileView> {

    public void makeLogout(){
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        spHelper.setLogin(context, null);
        spHelper.setBalance(context, null);
        spHelper.setName(context, null);
        spHelper.setImageUrl(context, null);
    }

    public  String getBalance() {
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        String balance = spHelper.getBalance(context);
        if (balance != null) {
            return balance;
        } else {
            Random random = new Random();
            double bal_value = random.nextDouble()*10000;
            DecimalFormat df = new DecimalFormat("#.00");
            balance = df.format(bal_value);
            spHelper.setBalance(context, balance);
            return balance;
        }
    }

    public String getName(){
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        String name = spHelper.getName(context);
        if (name != null) {
            return name;
        } else {
            String[] possible_names = {
                    "Котов Феодосий",
                    "Игорь Ардашев",
                    "Имя Три",
                    "Имя Четыре"
            };
            Random random = new Random();
            int idx = random.nextInt(possible_names.length);
            name = possible_names[idx];
            spHelper.setName(context, name);
            return name;
        }
    }
    public  String getImageUrl(){
        SharedPreferencesHelper spHelper = new SharedPreferencesHelper();
        Context context = MikOilApplication.getAppContext();
        String url = spHelper.getImageUrl(context);
        if (url != null) {
            return url;
        } else {
            String[] possible_names = {
                    "https://www.belnovosti.by/sites/default/files/article/2019/07/21/0q_0.jpg",
                    "https://www.e-xecutive.ru/uploads/article/image/1986360/thumb_Smirnova_Marina.jpg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRLKffAfgtgN8WDHG7NkhMww5J2BueJ7bojjsVSjfZU7ptfpbIu&usqp=CAU",
                    "https://im.kommersant.ru/Issues.photo/CORP/2019/03/01/KMO_111307_24199_1_t218_162046.jpg"
            };
            Random random = new Random();
            int idx = random.nextInt(possible_names.length);
            url = possible_names[idx];
            spHelper.setImageUrl(context, url);
            return url;
        }
    }
    }

