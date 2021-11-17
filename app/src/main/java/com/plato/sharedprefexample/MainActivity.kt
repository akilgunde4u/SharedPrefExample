package com.plato.sharedprefexample
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import javax.security.auth.login.LoginException
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    lateinit var login : Button
    lateinit var nameET : EditText
    lateinit var ageET:  EditText
    lateinit var checkBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemembered){

           // val intent = Intent(this, AnotherActivity::class.java)
         //   startActivity(intent)
         //   finish()
        }

        login = findViewById<Button>(R.id.login)
        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)
        checkBox = findViewById(R.id.checkBox)
        login.setOnClickListener{

            val name: String = nameET.text.toString()
            val age: Int = ageET.text.toString().toInt()
            val checked: Boolean = checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("AGE", age)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }

        }
    }

