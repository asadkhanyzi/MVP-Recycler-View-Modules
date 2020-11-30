package com.lepaya.test.mvp

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface BaseMvpView : MvpView {

    /**
     * Base method for all the views to be able show/hide loading state
     *
     * @param show if true - show loading, otherwise - hide
     */
    fun showLoading(show: Boolean)

    /**
     * Base method for all the views to be able show error
     *
     * @param error string error to show
     */
    fun showError(error: String)

    /**
     * Base method for all the views to be able show error
     *
     * @param errorResId string res id used to show error
     */
    fun showError(@StringRes errorResId: Int)


}