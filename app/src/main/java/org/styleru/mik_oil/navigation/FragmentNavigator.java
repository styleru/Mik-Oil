package org.styleru.mik_oil.navigation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface FragmentNavigator extends MvpView {

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
