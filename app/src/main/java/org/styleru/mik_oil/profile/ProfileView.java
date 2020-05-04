package org.styleru.mik_oil.profile;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface ProfileView extends MvpView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntrance();
}
