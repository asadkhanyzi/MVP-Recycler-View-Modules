package com.lepaya.test.ui.trainer

import com.lepaya.domain.models.Trainer
import com.lepaya.test.mvp.BaseMvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface TrainerListView : BaseMvpView {

    @AddToEndSingle
    fun showTrainerList(list: List<Trainer>)

    @Skip
    fun showTrainerDetailsActivity()



}
