package com.tecsup.edu.lab9_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tecsup.edu.lab9_room.informations.InformationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonVer = findViewById<Button>(R.id.darClick)
        buttonVer.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))
        }


    }
}