package org.styleru.mik_oil.profile;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ProfileView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void fillProfile(Profile profile);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntrance();

}
