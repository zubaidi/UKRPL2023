package com.codepelita.ukrpl

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage("Anda seorang Laki-Laki dengan usia ${usia}, Tinggi Badan ${tb}cm, dan Berat Badan ${bb}kg adalah ${hasil} kal")
                    .setPositiveButton("Simpan Data", DialogInterface.OnClickListener{
                        dialogInterface, i -> finish()
                    })
                    .setNegativeButton("Batal", DialogInterface.OnClickListener{
                            dialogInterface, i -> dialogInterface.cancel()
                    })
                var alert = alertDialog.create()
                alert.setTitle("Hasil Perhitungan")
                alert.show()
            }
            Toast.makeText(this, "hasil: ${ usia }", Toast.LENGTH_SHORT).show()
        } else {
            if( usia.isNotEmpty() && tb.isNotEmpty() && bb.isNotEmpty() ) {
                var usiaData = usia.toDouble()
                var bbData = bb.toDouble()
                var tbData = tb.toDouble()
            }

        }
    }
}