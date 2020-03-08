package org.styleru.mik_oil;

import androidx.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RegistrationView extends MvpView {

    enum Field {
        NAME, PHONE, PASSWORD, REPEATING_PASSWORD, ALL
    }

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationError(RegistrationView.Field field, @StringRes int messageRes);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);
}
