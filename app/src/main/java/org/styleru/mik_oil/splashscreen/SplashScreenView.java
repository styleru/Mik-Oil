package org.styleru.mik_oil.splashscreen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashScreenView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntrance();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToProfile();
}