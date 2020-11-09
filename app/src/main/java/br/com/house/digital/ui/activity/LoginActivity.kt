package br.com.house.digital.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.house.digital.R
import br.com.house.digital.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
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
        binding.includeContentLogin.buttonLogin.setOnClickListener(this)
        binding.includeContentLogin.buttonRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonLogin -> {
                startActivity(Intent(this@LoginActivity, LoginRegisterActivity::class.java))
            }
            R.id.buttonRegister -> {
                startActivity(Intent(this@LoginActivity, LoginRegisterActivity::class.java))
            }
        }
    }
}