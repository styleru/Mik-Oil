package org.styleru.mik_oil;

import androidx.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoginView extends MvpView {

    enum Field {
        LOGIN, PASSWORD, ALL
    }

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnabled(boolean enabled);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationError(Field field, @StringRes int messageRes);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMain();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);
}
