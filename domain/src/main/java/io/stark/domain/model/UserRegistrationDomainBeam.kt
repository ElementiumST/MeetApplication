package io.stark.domain.model

data class UserRegistrationDomainBeam(
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
