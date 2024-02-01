package io.stark.domain.repository

import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam

interface UserRepository {
    suspend fun createUser(userData: UserRegistrationDomainBeam)

    suspend fun loginUser(loginUserDomainBeam: LoginUserDomainBeam): AuthSetDomainBeam
}