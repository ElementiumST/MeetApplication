package io.stark.data

interface StorageApi {
    fun saveString(key: String, value: String)

    fun saveMap(map: Map<String, String>)

    fun getString(key: String): String

}