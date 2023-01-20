package com.codepelita.ukrpl

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepelita.ukrpl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recylerAdapter: RecyclerView.Adapter<*>
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

        val dataList = mutableListOf<Data>()
        binding.listData.layoutManager = LinearLayoutManager(this)

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
                alertDialog.setMessage("Anda seorang ${ binding.cbPria.text.toString() } dengan usia ${usia}, Tinggi Badan ${tb}cm, dan Berat Badan ${bb}kg adalah ${hasil} kal")
                    .setPositiveButton("Simpan Data", DialogInterface.OnClickListener{
                        dialogInterface, i ->
                        val data = Data("Laki-Laki", usia.toInt(), bb.toInt(), tb.toInt(), hasil.toString().toDouble() )
                        dataList.add(data)
                    })
                    .setNegativeButton("Batal", DialogInterface.OnClickListener{
                            dialogInterface, i -> dialogInterface.cancel()
                    })
                var alert = alertDialog.create()
                alert.setTitle("Hasil Perhitungan")
                alert.show()
            }
        } else {
            if( usia.isNotEmpty() && tb.isNotEmpty() && bb.isNotEmpty() ) {
                var usiaData = usia.toDouble()
                var bbData = bb.toDouble()
                var tbData = tb.toDouble()
                hasil = 655 + (9.653 * bbData) + (1.850 * tbData) - (4.676 * usiaData)
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage("Anda seorang ${ binding.cbWanita.text.toString() } dengan usia ${usia}, Tinggi Badan ${tb}cm, dan Berat Badan ${bb}kg adalah ${hasil} kal")
                    .setPositiveButton("Simpan Data", DialogInterface.OnClickListener{
                            dialogInterface, i ->
                        val data = Data("Perempuan", usia.toInt(), bb.toInt(), tb.toInt(), hasil.toString().toDouble() )
                        dataList.add(data)

                    })
                    .setNegativeButton("Batal", DialogInterface.OnClickListener{
                            dialogInterface, i -> dialogInterface.cancel()
                    })
                var alert = alertDialog.create()
                alert.setTitle("Hasil Perhitungan")
                alert.show()

            }
        }
        val adapter = AdapterResult(dataList)
        binding.listData.adapter = adapter
    }
}