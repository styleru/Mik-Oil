package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ViewLogin extends MvpView {

    @StateStrategyType(AddToEndSingleTagStrategy.class)
    void changeProgressState(boolean processing);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToEntrance();

    @StateStrategyType(AddToEndSingleTagStrategy.class)
    void showToast(String text);

    @StateStrategyType(AddToEndSingleTagStrategy.class)
    void showToast(int text);
}