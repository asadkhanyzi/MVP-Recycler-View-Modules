package com.lepaya.test.ui.trainer.detail

import com.lepaya.domain.models.Trainer
import com.lepaya.test.mvp.BaseMvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface TrainerDetailsView : BaseMvpView {
    @AddToEndSingle
    fun showTrainerDetails(selectedTrainer: Trainer?)

}
