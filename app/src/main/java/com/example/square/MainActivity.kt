package com.example.square

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
const val EXTRA_SQUARE_SIZE = "com.example.Square.SQUARE_SIZE"


class MainActivity : AppCompatActivity() {
    private lateinit var Square_button: Button
    private lateinit var Instructions: TextView
    private lateinit var Show_Square_button:LinearLayout
    private val SquareResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Result -> handleSquareResult(result)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Square_button = findViewById(R.id.Square_button)
        Instructions = findViewById(R.id.Instrutions)
        Show_Square_button = findViewById(R.id.Show_square_button)
        val intialprogress = Square_button
        updateSquare(intialprogress)

        Show_Square_button.setOnClickListener{
            showSquare()

        }


    }
    private fun showSquare(){
        val showSquareIntent = intent(this,Activity::class.java)
        showSquareIntent.putExta(EXTRA_SQUARE_SIZE,Square_button.progress)
       // startActivity(showSquareIntent)
        SquareResult.launch(showSquareIntent)
    }
    private fun handleSquareResult(result:ActivityResult){

    }
}