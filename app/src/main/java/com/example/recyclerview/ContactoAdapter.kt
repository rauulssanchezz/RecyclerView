package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemContactoBinding

class ContactoAdapter(var listadoContacto: MutableList<Contacto>, private val listener: MainActivity):RecyclerView.Adapter<ContactoAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding=ItemContactoBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listadoContacto.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto=listadoContacto.get(position)

        holder.binding.nombreContacto.text=contacto.nombre
    }
}