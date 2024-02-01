package io.stark.data

import io.stark.data.model.CreateUserData
import retrofit2.http.POST


interface SomeApi {

    @POST("user/create")
    fun createNewUser(createUserData: CreateUserData)


}