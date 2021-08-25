package com.myself.mynotebook.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myself.mynotebook.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
    }
}