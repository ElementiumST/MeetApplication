package io.stark.data.wrappers

internal interface Wrapper<T, K> {
    fun wrap(from: T): K

    fun unWrap(from: K) : T
}