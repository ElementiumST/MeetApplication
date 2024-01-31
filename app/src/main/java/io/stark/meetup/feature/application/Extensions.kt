package io.stark.meetup.feature.application

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

/**
 * Check contains view model in VM store
 */
fun <T: ViewModel> ViewModelStore.hasViewModel(modelClass: Class<T>): Boolean {
    val canonicalName = modelClass.canonicalName
        ?: throw IllegalArgumentException("Local and anonymous classes can not be ViewModels")
    return keys().contains(canonicalName)
}

/**
 * Анологичен обычному вызову "ViewModelProvider(this, factory).get(viewModelClass)"
 * За исключением, что если модель уже есть в сторе, то метод получения
 * factory из [provideViewModelFactory] не вызывается
 * Сделанно для того, что бы лишний раз не вызывать создание factory
 */
fun <T: ViewModel> Fragment.lazyViewModelGet(
    viewModelClass: Class<T>,
    provideViewModelFactory: () -> ViewModelProvider.Factory
): T {
    return if (viewModelStore.hasViewModel(viewModelClass)) {
        ViewModelProvider(this)[viewModelClass]
    } else {
        ViewModelProvider(this, provideViewModelFactory.invoke())[viewModelClass]
    }
}