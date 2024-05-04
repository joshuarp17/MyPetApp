 package com.joshuar.mypetapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

 class NewActivity : AppCompatActivity() {
     //Declare my variables
     private lateinit var feedButton: Button
     private lateinit var cleanButton: Button
     private lateinit var playButton: Button
     private lateinit var dogImageView: ImageView

     class myPet(var myPet: String) {

     }
     private var happiness =100
     private var cleanliness =100
     private var hungry =0

     @SuppressLint("MissingInflatedId")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_new)

         dogImageView = findViewById(R.id.dogImageView)

         //buttons
         val feedButton = findViewById<Button>(R.id.feedButton)
         val cleanButton = findViewById<Button>(R.id.cleanButton)
         val playButton = findViewById<Button>(R.id.playButton)


         updateUI()

         feedButton.setOnClickListener {
             feedPet()
             updateUI()
             dogImageView.setImageResource(R.drawable.dog_feed)

         }

         cleanButton.setOnClickListener {
             cleanPet()
             updateUI()
             dogImageView.setImageResource(R.drawable.dog_clean)

         }

         playButton.setOnClickListener {
             playPet()
             updateUI()
             dogImageView.setImageResource(R.drawable.dog_play)
         }
     }

     //Feeding the pet
     private fun feedPet() {
         hungry += 10
         if (hungry > 100) hungry = 100
         happiness += 5
         cleanliness-= 5
     }

     //Playing with the pet
     private fun playPet() {
         happiness += 10
         if (happiness > 100) happiness = 100
         hungry -= 5
         if (hungry > 100) hungry = 100
         cleanliness -= 5
         if (cleanliness  < 0)  cleanliness = 0
     }

     //Cleaning the pet
     private fun cleanPet() {
         cleanliness = 100
         happiness -= 5
         if (happiness <0) happiness = 0
     }

         private fun updateUI() {
             val happyTextView = findViewById<TextView>(R.id.happyTextView)
             val cleanTextView= findViewById<TextView>(R.id.cleanTextView)
             val hungryTextView = findViewById<TextView>(R.id.hungryTextView)

             happyTextView.text ="Happy: $happiness"
             cleanTextView.text ="Clean: $cleanliness"
             hungryTextView.text ="Hungry: $hungry"


         }


     }


