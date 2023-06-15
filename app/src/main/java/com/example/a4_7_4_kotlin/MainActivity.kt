package com.example.a4_7_4_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_7_4_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view: View =binding.root
        setContentView(view)
        initViews()
    }
    fun initViews(){
        binding.edText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Matn o'zgarishidan oldin nima qilish kerakligini ko'rsatadi
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Matn o'zgarishi bo'lganda nima qilish kerakligini ko'rsatadi
            }

            override fun afterTextChanged(s: Editable) {
                // Matn o'zgarishidan so'ng nima qilish kerakligini ko'rsatadi
                // binding.tvText.setText(s.toString());
            }
        })

        binding.edText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                // Enter tugmasi bosilganda nima qilish kerakligini ko'rsatadi
                show_msg()
                return@OnKeyListener true
            }
            binding.tvText.text = "xayr"
            false
        })

        binding.button.setOnClickListener { show_msg() }

    }

    private fun show_msg() {
        binding.tvText.text = binding.edText.text.toString()
    }

}