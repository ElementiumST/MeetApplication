package io.stark.data

import io.stark.data.model.AuthResponse
import io.stark.data.model.CreateUserData
import io.stark.data.model.LoginUserData
import retrofit2.Call
import retrofit2.http.POST


interface SomeApi {

    @POST("user/create")
    fun createNewUser(createUserData: CreateUserData)

    @POST("user/login")
    fun authByLogin(loginUserData: LoginUserData): Call<AuthResponse>

    @POST("user/auth")
    fun authByRefreshToken(refreshToken: String): Call<AuthResponse>

}