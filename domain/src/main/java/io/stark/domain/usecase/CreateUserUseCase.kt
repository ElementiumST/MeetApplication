package io.stark.domain.usecase

import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam

interface CreateUserUseCase {
    suspend fun execute(userRegistrationDomainBeam: UserRegistrationDomainBeam): AuthSetDomainBeam
}