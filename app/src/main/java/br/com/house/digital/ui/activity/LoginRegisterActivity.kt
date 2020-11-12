package br.com.house.digital.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.house.digital.MainActivity
import br.com.house.digital.R
import br.com.house.digital.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.includeToolbar.materialToolbar
        setSupportActionBar(toolbar)
        setTitle(R.string.title_default)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setClickListener()
    }

    private fun setClickListener() {
        binding.buttonRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonRegister -> {
                startActivity(Intent(this@LoginRegisterActivity, MainActivity::class.java))
            }
        }
    }

}