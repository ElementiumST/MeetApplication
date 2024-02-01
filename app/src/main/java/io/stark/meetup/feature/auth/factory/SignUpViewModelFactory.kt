package io.stark.meetup.feature.auth.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.stark.domain.repository.UserRepository
import io.stark.meetup.feature.auth.viewmodel.SignUpViewModel

class SignUpViewModelFactory(
    private val userRepository: UserRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(userRepository) as T
    }
}