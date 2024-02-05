package io.stark.domain.usecase

import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.repository.UserRepository

class UpdateAuthSetUseCaseImpl(
    private val userRepository: UserRepository
) : UpdateAuthSetUseCase {
    override suspend fun execute(): AuthSetDomainBeam? {
        var cashedAuthSet: AuthSetDomainBeam? = null
        runCatching { cashedAuthSet = userRepository.getCachedAuthSet() }
            .onFailure { return null }

        var newAuthSet: AuthSetDomainBeam? = null
        runCatching { newAuthSet =  userRepository.updateAuthSet(cashedAuthSet!!.refreshToken) }

        if (newAuthSet != null) {
            userRepository.saveAuthSet(newAuthSet!!)
            return newAuthSet
        }

        var cachedLoginData: LoginUserDomainBeam? = null
        runCatching { cachedLoginData = userRepository.getCachedLoginData() }
            .onFailure { return null }

        runCatching { return userRepository.loginUser(cachedLoginData!!) }
            .onFailure { return null }
        return null
    }
}