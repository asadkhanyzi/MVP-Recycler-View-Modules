package com.lepaya.test.ui.trainer.detail

import com.lepaya.domain.interactors.TrainerInteractor
import com.lepaya.test.mvp.BaseMvpPresenter

class TrainerDetailsPresenter(
    private val trainerInteractor: TrainerInteractor
) : BaseMvpPresenter<TrainerDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getTrainer()
    }

    private fun getTrainer() {
        viewState.showTrainerDetails(trainerInteractor.selectedTrainer)
    }
}
