package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.Map;

public interface RecoveryView extends MvpView {

    enum Field {
        PHONE, ALL
    }

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationErrors(Map<Field, Integer> errors);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToRecoverySms();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);
}
