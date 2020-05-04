package org.styleru.mik_oil.profile;

import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Random;

class ProfilePresenter extends MvpPresenter<ProfileView> {

    ProfileFilling getProfileFilling() {
        String[] userNames = {"Дмитрий", "Катя", "Влад", "Никита Рябов", "Карпова Иришка"};
        String[] avatarURLs = {"https://sun9-64.userapi.com/c846523/v846523778/1cdb08/QapTu9FAIkM.jpg",
                "https://sun9-48.userapi.com/c855024/v855024598/1930df/12795C-o2ig.jpg",
                "https://sun9-71.userapi.com/c836234/v836234471/2fbfb/TnlCdq2OoFw.jpg",
                "https://www.hse.ru/pubs/share/thumb/138570283:c196x196+0+22:r190x190!",
                "https://www.hse.ru/pubs/share/thumb/141623051:c708x708+0+16:r190x190!"
        };
        double[] cardBalances = {1000, 999, 99999, 0.1, 77};
        String[] cardNumbers = {"123154", "111111", "663626", "523521", "000000"};
        ArrayList<ProfileFilling> profileFillings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            profileFillings.add(new ProfileFilling(userNames[i], avatarURLs[i],
                    cardBalances[i], cardNumbers[i]));
        }

        Random random = new Random();
        return profileFillings.get(random.nextInt(profileFillings.size()));
    }
}