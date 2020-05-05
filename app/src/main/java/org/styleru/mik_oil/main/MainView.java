package org.styleru.mik_oil.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface MainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntranceFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToProfileFragment();

}
