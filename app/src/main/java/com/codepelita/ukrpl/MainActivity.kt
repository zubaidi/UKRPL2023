package com.codepelita.ukrpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.codepelita.ukrpl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            hitungKalori()
        }
    }

    private fun hitungKalori() {
        var jenisKelaminPria = binding.cbPria
        var jenisKelaminWanita = binding.cbWanita
        var usia = binding.txtUsia.text.toString()
        var tb = binding.txtTinggi.text.toString()
        var bb = binding.txtBerat.text.toString()
        var hasil: Double

        jenisKelaminPria.setOnClickListener {
            binding.cbPria.isChecked = true
            binding.cbWanita.isChecked = false
        }
        jenisKelaminWanita.setOnClickListener {
            binding.cbPria.isChecked = false
            binding.cbWanita.isChecked = true
        }
        if (binding.cbPria.isChecked) {

            if( usia.isNotEmpty() && tb.isNotEmpty() && bb.isNotEmpty() ) {
                var usiaData = usia.toDouble()
                var bbData = bb.toDouble()
                var tbData = tb.toDouble()
                hasil = 665 + (13.75 * bbData) + (5.003 * tbData) - (6.75 * usiaData)
                binding.txtHasil.text = hasil.toString()
                Toast.makeText(this, "${usiaData}", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "hasil: ${ usia }", Toast.LENGTH_SHORT).show()
        } else {
            if( usia.isNotEmpty() && tb.isNotEmpty() && bb.isNotEmpty() ) {
                var usiaData = usia.toDouble()
                var bbData = bb.toDouble()
                var tbData = tb.toDouble()
                hasil = 655 + (9.563 * bbData) + (1.850 * tbData) - (4.676 * usiaData)
                binding.txtHasil.text = hasil.toString()
            }

        }
    }
}