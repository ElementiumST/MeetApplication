package io.stark.authfeature.di

interface AuthSourceProvider {
    var source: AuthSource

    companion object : AuthSourceProvider by AuthSourceStore
}