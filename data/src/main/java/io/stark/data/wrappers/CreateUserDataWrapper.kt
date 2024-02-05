package io.stark.data.wrappers

import io.stark.data.model.CreateUserData
import io.stark.domain.model.UserRegistrationDomainBeam

internal object CreateUserDataWrapper: Wrapper<CreateUserData, UserRegistrationDomainBeam> {
    override fun wrap(from: CreateUserData): UserRegistrationDomainBeam {
        return UserRegistrationDomainBeam(from.login, from.password, from.firstName, from.lastName)
    }

    override fun unWrap(from: UserRegistrationDomainBeam): CreateUserData {
        return CreateUserData(from.login, from.password, from.firstName, from.lastName)
    }
}