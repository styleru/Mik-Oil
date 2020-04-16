package org.styleru.mik_oil.verificationkey;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.Map;

public interface VerificationKeyView extends MvpView {

    enum Field {
        VERIFICATION_KEY
    }

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    /**
     * Show validation errors for fields in view
     *
     * @param errors map of {@link Field} to string resource of error
     */
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationErrors(Map<Field, Integer> errors);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);
}
