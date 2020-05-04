package org.styleru.mik_oil.profile;

import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Random;

class ProfilePresenter extends MvpPresenter<ProfileView> {

    ProfileFilling getProfileFilling () {
        String[] name = {"Данила Павленко", "Панила Давленко", "Даненко Павнила", "Великий", "Тот самый"};
        String[] cardNumber = {"0001234", "0002345", "0003456", "7777777", "0000000"};
        String[] urlPhoto = {"https://sun9-43.userapi.com/c844520/v844520018/1ee61b/E0rlWkwzs9s.jpg",
                "https://sun1-21.userapi.com/atLrz-jvg52qeOKO8UG6wu9_UTbHMIVYB7nq5g/KePNIfM6JeM.jpg",
                "https://sun1-91.userapi.com/futPKVnn2CFgqnSH_12_50ajg1TCyi5bkZipZg/VUkgmPkUm2A.jpg",
                "https://sun9-71.userapi.com/c622520/v622520168/4198/mJzoIS9lrpw.jpg",
                "https://sun9-50.userapi.com/c622622/v622622756/2212a/szMXp98s1O8.jpg"};
        double scoreCard = 2345678;

        ArrayList<ProfileFilling> fillProfile = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fillProfile.add(new ProfileFilling(name[i], cardNumber[i], urlPhoto[i], scoreCard));
        }

        Random random = new Random();
        int rand = random.nextInt(5);

        return fillProfile.get(rand);
    }


}
