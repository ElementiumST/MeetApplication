package io.stark.authfeature.di

import dagger.Component
import io.stark.authfeature.viewmodel.AuthViewModel


@Component(modules = [AuthModule::class], dependencies = [AuthSource::class])
@AuthScope
internal interface AuthComponent {
    fun inject(authViewModel: AuthViewModel)
    @Component.Builder
    interface Builder {
        fun source(source: AuthSource): Builder
        fun build() : AuthComponent
    }

}