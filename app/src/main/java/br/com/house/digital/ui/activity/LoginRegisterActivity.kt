package br.com.house.digital.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.house.digital.R
import br.com.house.digital.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)
        setTitle(R.string.title_default)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}