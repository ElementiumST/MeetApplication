package io.stark.meetup.feature.auth.di

import dagger.Module
import dagger.Provides
import io.stark.data.repos.UserRepositoryMockImpl
import io.stark.domain.repository.UserRepository
import io.stark.meetup.feature.auth.factory.SignUpViewModelFactory

@Module
class AuthModule {


    @Provides
    fun provideCreateUserRepository(): UserRepository {
        return UserRepositoryMockImpl()
    }

    @Provides
    fun provideSignUpViewModelFactory(
        userRepository: UserRepository
    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(userRepository)
    }
}