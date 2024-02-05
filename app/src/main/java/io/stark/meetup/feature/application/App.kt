package io.stark.meetup.feature.application

import android.app.Application
import io.stark.authfeature.di.AuthSourceStore
import io.stark.meetup.feature.application.di.AppComponent
import io.stark.meetup.feature.application.di.DaggerAppComponent

class App: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .sharedPreferences(getSharedPreferences("appdata", MODE_PRIVATE))
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        AuthSourceStore.source = appComponent
    }
}