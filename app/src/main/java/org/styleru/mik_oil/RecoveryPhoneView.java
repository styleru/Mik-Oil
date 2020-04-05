package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.Map;

public interface RecoveryPhoneView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    /**
     * Show validation errors for fields in view
     *
     * @param errors map of {@link RecoveryPhoneView.Field} to string resource of error
     */
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationErrors(Map<RecoveryPhoneView.Field, Integer> errors);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToRecoveryCodeFragment();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);

    enum Field {
        PHONE, ALL
    }
}
