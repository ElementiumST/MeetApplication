package io.stark.meetup.feature.application.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import io.stark.data.SomeApi
import io.stark.data.StorageApi
import io.stark.data.repos.UserRepositoryImpl
import io.stark.domain.repository.UserRepository
import io.stark.domain.usecase.UpdateAuthSetUseCase
import io.stark.domain.usecase.UpdateAuthSetUseCaseImpl
import io.stark.meetup.feature.application.StorageApiImpl

@Module(includes = [RetrofitModule::class])
class AppModule(
) {
    @AppScope
    @Provides
    fun provideRepository(someApi: SomeApi, storageApi: StorageApi): UserRepository {
        return UserRepositoryImpl(someApi, storageApi)
    }

    @AppScope
    @Provides
    fun provideStorageApi(sharedPreferences: SharedPreferences): StorageApi {
        return StorageApiImpl(sharedPreferences)
    }

    @AppScope
    @Provides
    fun provideUpdateAuthSetUseCase(
        userRepository: UserRepository
    ) : UpdateAuthSetUseCase {
        return UpdateAuthSetUseCaseImpl(userRepository)
    }
}
