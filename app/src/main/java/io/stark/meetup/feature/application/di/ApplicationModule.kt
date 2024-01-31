package io.stark.meetup.feature.application.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val context: Context
) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}
