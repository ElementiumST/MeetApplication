package io.stark.meetup.feature.application

import android.content.SharedPreferences
import io.stark.data.StorageApi

class StorageApiImpl(
    private val sharedPreferences: SharedPreferences
): StorageApi {
    override fun saveString(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    override fun saveMap(map: Map<String, String>) {
        val editor = sharedPreferences.edit()
        map.forEach { (key, value) ->
            editor.putString(key, value)
        }
        editor.apply()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, null) ?: throw IllegalStateException("value with key: $key not found in storage")
    }
}