package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoginFragmentView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void progress(boolean isGoing);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(int a);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String string);

}
