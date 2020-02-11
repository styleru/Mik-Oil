package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface Android_2_View extends MvpView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void SetProgressBar(boolean show);
    void ShowToast(boolean succes);
}
