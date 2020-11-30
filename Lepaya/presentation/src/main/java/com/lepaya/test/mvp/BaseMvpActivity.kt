package com.lepaya.test.mvp

import android.os.Bundle
import androidx.annotation.StringRes
import com.lepaya.test.utils.showToast
import moxy.MvpAppCompatActivity

abstract class BaseMvpActivity : MvpAppCompatActivity(), BaseMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Show Loading etc if required
    }

    /**
     * Show error for the view
     * Child view should override this method for specific realization
     */
    override fun showError(error: String) {
        // Default implementation of error showing is snack bar
        showToast(error)
    }

    /**
     * Show error for the view
     * Child view should override this method for specific realization
     */
    override fun showError(@StringRes errorResId: Int) {
        // Default implementation of error showing is snack bar
        showToast(errorResId)
    }


}