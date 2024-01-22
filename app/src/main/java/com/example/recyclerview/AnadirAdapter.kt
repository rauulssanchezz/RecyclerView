package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemNuevoBinding

class AnadirAdapter(var listaItem: MutableList<Item>, private val listener: AnadirItems):RecyclerView.Adapter<AnadirAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding= ItemNuevoBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nuevo,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listaItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=listaItem.get(position)

        holder.binding.nombre.text=item.nombre
    }
}