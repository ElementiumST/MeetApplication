package io.stark.data.repos

import io.stark.domain.model.UserRegistrationDomainBeam
import io.stark.domain.repository.CreateUserRepository


class CreateUserRepositoryImpl(

): CreateUserRepository {
    override fun createUser(userData: UserRegistrationDomainBeam): Boolean {
        return true
    }
}