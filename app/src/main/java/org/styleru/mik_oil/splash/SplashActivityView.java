package org.styleru.mik_oil.splash;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashActivityView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startMainFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startEntranceFragment();
}