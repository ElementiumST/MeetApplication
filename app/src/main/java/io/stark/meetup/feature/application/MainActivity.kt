package io.stark.meetup.feature.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.stark.meetup.R
import io.stark.meetup.feature.auth.view.SignUpFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.root, SignUpFragment.newInstance()).commit()
    }
}