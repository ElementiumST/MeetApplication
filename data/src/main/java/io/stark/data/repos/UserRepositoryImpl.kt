package io.stark.data.repos

import io.stark.data.SomeApi
import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam
import io.stark.domain.repository.UserRepository


class UserRepositoryImpl(
    private val someApi: SomeApi
): UserRepository {
    override suspend fun createUser(userData: UserRegistrationDomainBeam) {
        TODO()
    }

    override suspend fun loginUser(loginUserDomainBeam: LoginUserDomainBeam): AuthSetDomainBeam {
        TODO()
    }
}