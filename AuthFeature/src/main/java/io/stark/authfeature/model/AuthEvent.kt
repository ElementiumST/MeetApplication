package io.stark.authfeature.model

sealed class AuthEvent {
    data object AuthCompleted: AuthEvent()

    data object TokenSetNotFounded: AuthEvent()
}