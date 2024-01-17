package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemAjedrezBinding

class AjedrezAdaptador(var lista: MutableList<Ficha>):RecyclerView.Adapter<AjedrezAdaptador.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding= ItemAjedrezBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ajedrez,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AjedrezAdaptador.ViewHolder, position: Int) {
        val ficha=lista.get(position)
        holder.binding.nombre.text=ficha.nombre
    }

    override fun getItemCount(): Int {
        return  lista.size
    }
}