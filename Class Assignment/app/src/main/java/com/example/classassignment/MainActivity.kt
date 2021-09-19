package com.example.classassignment
import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instantiating the share, view and next button
        var shareButton = findViewById<Button>(R.id.button_Share)
        var viewButton = findViewById<Button>(R.id.button_View)
        val next= findViewById<Button>(R.id.button_Next)


        //This is the share button function, it will allow us to share data to other Apps/Activities
        //with this intent filter in them
        shareButton.setOnClickListener {
            val intent = Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "This is Intent Trial it is working")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"select an option to proceed"))
        }


        //This is the view button function, it will allow us to share data to other Apps/Activities
        //with this intent filter in them
        viewButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }

        //This is the next button function, it will take us to the next Second activity B
        next.setOnClickListener {
            intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_left,R.anim.slide_right)

        }
    }
}