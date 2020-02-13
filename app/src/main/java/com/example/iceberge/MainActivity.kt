package com.example.iceberge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsbc.kinetic.login_ui.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Thread {
            Thread.sleep(5000)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }.start()

    }

}
