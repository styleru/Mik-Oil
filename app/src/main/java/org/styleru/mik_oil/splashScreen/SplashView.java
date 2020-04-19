package org.styleru.mik_oil.splashScreen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntrance();
}
