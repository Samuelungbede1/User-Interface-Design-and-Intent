package com.example.ikh

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Initializing the buttons created in the xml file
       // var smallButtonOne= findViewById<Button>(R.id.small_Button_one)
        //var smallButtonTwo=findViewById<Button>(R.id.small_Button_two)
        var swictch_button= findViewById<Button>(R.id.switch_id)



        val colorType: SharedPreferences= getSharedPreferences("color", 0)
        var myColor: SharedPreferences.Editor= colorType.edit()
        val isDarkColor: Boolean= colorType.getBoolean("night", false)


        if (isDarkColor){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        //Setting up the actions/condition to switch from light to dark mode
        swictch_button.setOnClickListener {
            if(isDarkColor){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                myColor.putBoolean("night", false)
                myColor.apply()
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                myColor.putBoolean("night", true)
                myColor.apply()
            }
        }

    }
}