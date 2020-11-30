package com.lepaya.data.api


import com.lepaya.data.entities.GetTrainersResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * API Interface
 * All possible API calls will be here
 */
interface Api {
    /**
     * API call to get all trainers
     */
    @GET("employee/employee")
    fun getTrainers(): Call<List<GetTrainersResponse>>
  }