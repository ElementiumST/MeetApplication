package io.stark.authfeature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.stark.authfeature.di.AuthSourceProvider
import io.stark.authfeature.di.DaggerAuthComponent
import io.stark.authfeature.model.AuthEvent
import io.stark.domain.repository.UserRepository
import io.stark.domain.usecase.UpdateAuthSetUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel(
) : ViewModel() {

    init {
        DaggerAuthComponent.builder()
            .source(AuthSourceProvider.source)
            .build()
            .inject(this)

    }

    @Inject lateinit var userRepository: UserRepository

    @Inject lateinit var updateAuthSetUseCase: UpdateAuthSetUseCase

    private val eventFlow: MutableSharedFlow<AuthEvent> = MutableSharedFlow()

    fun getEventFlow() = eventFlow.asSharedFlow()

    fun tryAuthByStore() {
        viewModelScope.launch(Dispatchers.IO) {
            if (updateAuthSetUseCase.execute() != null)
                eventFlow.emit(AuthEvent.AuthCompleted)
            else
                eventFlow.emit(AuthEvent.TokenSetNotFounded)
        }
    }
    companion object {
        const val TAG = "AuthViewModel"
    }
}