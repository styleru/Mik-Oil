package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoginView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void imitateRequest();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void changeVisibility(boolean isVisible);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void increaseProgress();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String toast_text);
}
