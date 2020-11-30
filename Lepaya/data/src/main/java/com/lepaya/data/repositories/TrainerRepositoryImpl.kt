package com.lepaya.data.repositories

import com.lepaya.data.api.Api
import com.lepaya.domain.exception.Failure
import com.lepaya.domain.models.Trainer
import com.lepaya.domain.repositories.TrainerRepository
import com.lepaya.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class TrainerRepositoryImpl(
private val api: Api
): TrainerRepository{
    override suspend fun getTrainers(): Either<Failure, List<Trainer>> {
       return withContext(Dispatchers.IO){
           try {
               val response = api.getTrainers().execute()
               when (response.isSuccessful){
                   false -> Either.Left(Failure.NetworkError)
                   true -> Either.Right(response.body()!!.map { it.toTrainer() })
               }

           }catch (e:Exception){
               Timber.e(e, "getTrainers: $e")
               Either.Left(Failure.NetworkError)
           }
       }
    }

}
