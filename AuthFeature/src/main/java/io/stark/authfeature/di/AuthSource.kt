package io.stark.authfeature.di

import io.stark.domain.repository.UserRepository
import io.stark.domain.usecase.UpdateAuthSetUseCase

interface AuthSource {
    val userRepository: UserRepository
    val updateAuthSetUseCase: UpdateAuthSetUseCase
}