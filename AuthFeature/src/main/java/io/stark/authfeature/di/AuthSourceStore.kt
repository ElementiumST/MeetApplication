package io.stark.authfeature.di

import kotlin.properties.Delegates.notNull

object AuthSourceStore : AuthSourceProvider {
    override var source: AuthSource by notNull()
}
