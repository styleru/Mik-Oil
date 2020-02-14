package org.styleru.mik_oil;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface Android_2_View extends MvpView {



    @StateStrategyType(AddToEndSingleStrategy.class)
    void SetProgressBar(boolean show);
    @StateStrategyType(OneExecutionStateStrategy.class)
    void ShowToast(boolean succes);
}
