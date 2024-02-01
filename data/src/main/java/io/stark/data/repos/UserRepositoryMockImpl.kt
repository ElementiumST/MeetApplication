package io.stark.data.repos

import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam
import io.stark.domain.repository.UserRepository
import java.util.UUID

class UserRepositoryMockImpl: UserRepository {
    override suspend fun createUser(userData: UserRegistrationDomainBeam) {
        return
    }

    override suspend fun loginUser(loginUserDomainBeam: LoginUserDomainBeam): AuthSetDomainBeam {
        return AuthSetDomainBeam(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        )
    }
}