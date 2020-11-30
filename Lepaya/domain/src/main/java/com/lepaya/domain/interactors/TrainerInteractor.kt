package com.lepaya.domain.interactors

import com.lepaya.domain.exception.Failure
import com.lepaya.domain.models.Trainer
import com.lepaya.domain.repositories.TrainerRepository
import com.lepaya.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TrainerInteractor(
    private val trainerRepository: TrainerRepository
) : BaseInteractor() {

    var selectedTrainer: Trainer? = null

    /*Get list of trainers */
    suspend fun getTrainers(): Either<Failure, List<Trainer>> {
        return withContext(Dispatchers.Default) {
            when (val result = trainerRepository.getTrainers()) {
                is Either.Left -> Either.Left(result.a)
                is Either.Right -> Either.Right(result.b)
            }
        }
    }

    /*Set selected trainer from list*/
    suspend fun setCurrentTrainer(
        trainer: Trainer
    ): Either<Failure, Boolean> {
        return withContext(Dispatchers.Default) {
            selectedTrainer = trainer
            Either.Right(true)
        }
    }

}
