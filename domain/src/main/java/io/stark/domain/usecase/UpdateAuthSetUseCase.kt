package io.stark.domain.usecase

import io.stark.domain.model.AuthSetDomainBeam

interface UpdateAuthSetUseCase {
    suspend fun execute(): AuthSetDomainBeam?
}