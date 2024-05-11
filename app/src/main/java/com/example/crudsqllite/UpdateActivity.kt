package com.example.crudsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudsqllite.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}