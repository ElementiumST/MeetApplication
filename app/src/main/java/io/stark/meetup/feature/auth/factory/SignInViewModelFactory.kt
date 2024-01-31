package io.stark.meetup.feature.auth.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.stark.meetup.feature.auth.viewmodel.SignInViewModel

class SignInViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel() as T
    }
}