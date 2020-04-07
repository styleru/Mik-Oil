package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RecoveryCodeView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationErrors();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();
}
