package com.example.example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.example1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.insult.observe(this) {
            binding.insult.text = it.insult
        }
        binding.buttonGetNewInsult.setOnClickListener {
            viewModel.getInsult()
        }
        viewModel.getInsult()
    }
}