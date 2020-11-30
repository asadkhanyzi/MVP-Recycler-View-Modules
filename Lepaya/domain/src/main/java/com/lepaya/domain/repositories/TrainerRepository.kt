package com.lepaya.domain.repositories

import com.lepaya.domain.exception.Failure
import com.lepaya.domain.models.Trainer
import com.lepaya.domain.utils.Either

interface TrainerRepository {
    suspend fun getTrainers(
    ): Either<Failure, List<Trainer>>
}