package com.lepaya.test.ui.trainer

import com.lepaya.domain.interactors.TrainerInteractor
import com.lepaya.domain.models.Trainer
import com.lepaya.domain.utils.Either
import com.lepaya.test.mvp.BaseMvpPresenter
import kotlinx.coroutines.launch

class TrainerListPresenter(
    private val trainerInteractor: TrainerInteractor
): BaseMvpPresenter<TrainerListView>() {
private lateinit var trainerList: List<Trainer>
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getTrainerList()
    }

    private fun getTrainerList() {
        launch {
            when(val result = trainerInteractor.getTrainers()){
                is Either.Left -> showFailure(result.a)
                is Either.Right -> {
                    trainerList = result.b
                    populateTrainersList(result.b)
                }
            }
        }
    }

    private fun populateTrainersList(trainerList: List<Trainer>) {
        when {
            trainerList.isEmpty() -> {
                // Handle UI accordingly
            }
        }

        when {
            trainerList.isNotEmpty() -> {
                viewState.showTrainerList(
                trainerList
                )
            }
        }
    }

    fun onTrainerClicked(trainerListItem: Trainer) {
        launch {
            when(val result = trainerInteractor.setCurrentTrainer(trainerListItem)){
                is Either.Left -> showFailure(result.a)
                is Either.Right -> {
                   viewState.showTrainerDetailsActivity()
                }
            }
        }
    }


}
