package br.com.house.digital.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.house.digital.R
import br.com.house.digital.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)

        setTitle(R.string.title_default)

        init()
    }

    private fun init() {

    }
}