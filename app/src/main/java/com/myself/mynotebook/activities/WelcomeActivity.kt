package com.myself.mynotebook.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.myself.mynotebook.R


class WelcomeActivity : AppCompatActivity(){


    var next_btn: AppCompatButton? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        instance();
        clickEvent();

    }

    private fun instance() {
        next_btn=findViewById(R.id.next_btn);
    }

    private fun clickEvent() {
        next_btn?.setOnClickListener {
            var clickintent = Intent(this@WelcomeActivity, UserCredetialsActivity::class.java)
            startActivity(clickintent)
        }
    }

}