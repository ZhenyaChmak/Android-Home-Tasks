package com.example.androidhometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidhometasks.ht2.CalculatorFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, CalculatorFragment())
            .commit()
    }

}