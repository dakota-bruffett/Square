package com.example.square


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.Touch
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
const val EXTRA_TAPPED_INSIDE_SQUARE = "com.example.Square.SQUARE_SIZE"
class Tap : AppCompatActivity() {
    private lateinit var poke:ImageView
    private lateinit var Touch:TextView
    private lateinit var Contain:View
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tap)
        poke = findViewById(R.id.Poke)
        Contain = findViewById(R.id.Contain)

        val pokeSize = intent.getIntExtra(EXTRA_SQUARE_SIZE, 100)
        if (pokeSize == 0){
            pokeSize == 1
        }
        poke.layoutParams.height = pokeSize
        poke.layoutParams.width = pokeSize

        poke.setOnClickListener {
            SquareTouched(true)

        }
        Contain.setOnClickListener {
            SquareTouched(false)
        }

    }

    private fun SquareTouched(Wasitpoked: Boolean) {
        val ResultIntent = Intent()
        ResultIntent.putExtra(EXTRA_TAPPED_INSIDE_SQUARE, Wasitpoked)
        setResult(RESULT_OK, ResultIntent)
        finish()

    }

}