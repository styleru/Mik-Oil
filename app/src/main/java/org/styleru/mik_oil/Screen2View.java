package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface Screen2View extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void Progress(boolean isGoing);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showToast(String string);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void Return();

}
