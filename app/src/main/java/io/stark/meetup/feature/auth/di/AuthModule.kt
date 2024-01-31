package io.stark.meetup.feature.auth.di

import dagger.Module
import dagger.Provides
import io.stark.data.repos.CreateUserRepositoryImpl
import io.stark.domain.repository.CreateUserRepository
import io.stark.meetup.feature.auth.factory.SignUpViewModelFactory

@Module
class AuthModule {

    @Provides
    fun provideCreateUserRepository(): CreateUserRepository {
        return CreateUserRepositoryImpl()
    }

    @Provides
    fun provideSignUpViewModelFactory(
        createUserRepository: CreateUserRepository
    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(createUserRepository)
    }
}