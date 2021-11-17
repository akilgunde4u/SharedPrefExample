package com.plato.sharedprefexample

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnotherActivity : AppCompatActivity() {

    lateinit var  preferences: SharedPreferences
    lateinit var nameTv: TextView
    lateinit var ageTv: TextView
    lateinit var logout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        nameTv = findViewById(R.id.nameTv)
        ageTv = findViewById(R.id.ageTv)
        logout = findViewById<Button>(R.id.logout)

        logout = findViewById(R.id.logout)
        logout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val name = preferences.getString("NAME","")
        nameTv.text = name
        val age = preferences.getInt("AGE", 0)
        ageTv.text = ""+age

      //  val intent = Intent(this, MainActivity::class.java)
     //   startActivity(intent)
    }
}