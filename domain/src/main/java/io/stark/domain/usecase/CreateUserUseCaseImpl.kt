package io.stark.domain.usecase

import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam
import io.stark.domain.repository.UserRepository

class CreateUserUseCaseImpl(
    private val userRepository: UserRepository
) : CreateUserUseCase {
    override suspend fun execute(userRegistrationDomainBeam: UserRegistrationDomainBeam): AuthSetDomainBeam {
        userRepository.createUser(userRegistrationDomainBeam)
        return userRepository.loginUser(
            LoginUserDomainBeam(
                userRegistrationDomainBeam.login,
                userRegistrationDomainBeam.password
            )
        )
    }
}