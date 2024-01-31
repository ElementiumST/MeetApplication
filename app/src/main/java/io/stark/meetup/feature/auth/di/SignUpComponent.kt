package io.stark.meetup.feature.auth.di

import dagger.Component
import io.stark.meetup.feature.auth.factory.SignUpViewModelFactory


@Component(modules = [AuthModule::class])
interface SignUpComponent {

    fun provideViewModelFactory() : SignUpViewModelFactory

}