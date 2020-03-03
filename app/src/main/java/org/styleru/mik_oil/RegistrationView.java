package org.styleru.mik_oil;

import androidx.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RegistrationView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToPhoneNumberChecking();

    enum Field {
        USER_NAME, USER_PHONE_NUMBER, USER_PASSWORD, USER_REPEAT_PASSWORD, ALL
    }
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showValidationError(RegistrationView.Field field, @StringRes int messageRes);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void changeProgressState(boolean processing);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String text);
}
