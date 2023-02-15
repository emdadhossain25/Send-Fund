package com.example.sendfund.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendfund.R
import com.example.sendfund.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}