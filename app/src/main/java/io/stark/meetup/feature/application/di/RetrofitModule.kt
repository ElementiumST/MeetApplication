package io.stark.meetup.feature.application.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.stark.data.SomeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @AppScope
    fun provideSomeApi(retrofit: Retrofit): SomeApi {
        return retrofit.create(SomeApi::class.java)
    }

    @Provides
    @AppScope
    fun provideRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(logger)
            .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}