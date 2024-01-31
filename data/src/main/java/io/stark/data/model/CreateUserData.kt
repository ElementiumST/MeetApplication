package io.stark.data.model

data class CreateUserData(
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String
) {

}