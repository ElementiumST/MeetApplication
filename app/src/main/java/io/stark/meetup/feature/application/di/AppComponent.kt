package io.stark.meetup.feature.application.di

import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import io.stark.authfeature.di.AuthSource
import io.stark.domain.repository.UserRepository
import io.stark.domain.usecase.UpdateAuthSetUseCase

@AppScope
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent: AuthSource {

    override val userRepository: UserRepository

    override val updateAuthSetUseCase: UpdateAuthSetUseCase


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun sharedPreferences(sharedPreferences: SharedPreferences): Builder

        fun build(): AppComponent
    }
}