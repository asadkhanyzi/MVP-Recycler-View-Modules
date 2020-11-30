package com.lepaya.test.mvp

import com.lepaya.domain.exception.Failure
import com.lepaya.test.R
import kotlinx.coroutines.CoroutineScope
import moxy.MvpPresenter
import moxy.presenterScope
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class BaseMvpPresenter<View : BaseMvpView> :
    MvpPresenter<View>(),
    CoroutineScope,
    KoinComponent {

    override val coroutineContext: CoroutineContext
        get() = presenterScope.coroutineContext

    /**
     * Base implementation of handling @see Failure object
     * that can be returned from the interactors
     *
     * @param failure Failure to handle and show appropriate message to the user
     */
    protected fun showFailure(failure: Failure) {
        viewState.showLoading(false)
        when (failure) {

            is Failure.NetworkError -> viewState.showError(R.string.errorNetworkConnection)
            is Failure.GeneralError -> viewState.showError(failure.message)

            // Default error
            else -> viewState.showError(R.string.errorUnknownError)
        }
    }
}