package com.codepelita.ukrpl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterResult(private val list: MutableList<Data>) : RecyclerView.Adapter<AdapterResult.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var jk = itemView.findViewById<TextView>(R.id.tvJenisKelamin)
        var usia = itemView.findViewById<TextView>(R.id.tvUsia)
        var tb = itemView.findViewById<TextView>(R.id.tvTinggiBadan)
        var bb = itemView.findViewById<TextView>(R.id.tvBeratBadan)
        var hasil = itemView.findViewById<TextView>(R.id.tvNilaiKalo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(
            R.layout.result_adaptor, parent, false
        )
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jk.text = list[position].jeniskelamin
        holder.usia.text = list[position].usia.toString()
        holder.tb.text = list[position].tinggi.toString()
        holder.bb.text = list[position].berat_badan.toString()
        holder.hasil.text = list[position].hasil.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}