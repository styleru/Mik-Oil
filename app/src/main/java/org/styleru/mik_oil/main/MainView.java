package org.styleru.mik_oil.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import org.styleru.mik_oil.navigation.FragmentNavigator;

interface MainView extends MvpView, FragmentNavigator {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToLoginFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntranceFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToPasswordRecoveryFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToVerificationKeyFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToRegistrationFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToProfileFragment();

}
