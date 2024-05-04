package com.joshuar.mypetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //making use of the keyword lateinit
    //this allows to declare a variable and initialize at a later stage
    private lateinit var startButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //find reference to the button by using its ID
        //Initialize the variable by making use of findviewby ID method

        startButton = findViewById(R.id.startButton)

        //making the button clickable
        //we are making use of a onsetClickListener
        //creating an Intent to access the new activity

        startButton.setOnClickListener {

            var intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }
    }
}
