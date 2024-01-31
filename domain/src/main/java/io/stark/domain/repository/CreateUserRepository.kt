package io.stark.domain.repository

import io.stark.domain.model.UserRegistrationDomainBeam

interface CreateUserRepository {
    fun createUser(userData: UserRegistrationDomainBeam): Boolean
}