package com.example.square

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val showSquareIntent = Intent(this,Activity::class.java)
        showSquareIntent.putExta(EXTRA_SQUARE_SIZE,Square_button.progress)
       // startActivity(showSquareIntent)
        SquareResult.launch(showSquareIntent)
    }
    private fun handleSquareResult(result:ActivityResult){
        if (result.resultCode == RESULT_OK){
            val intent = result.resultData
            val tapped = intent?.getBooleanExtra(EXTRA_TAPPED_INSIDE_SQUARE, false)?:false
            val message = if (tapped) { "You tapped the square"} else {"Touch the square"}
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    }
}