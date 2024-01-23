package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemNuevoBinding

class AnadirAdapter(var listaItem: MutableList<Item>, private val listener: AnadirItems):RecyclerView.Adapter<AnadirAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding= ItemNuevoBinding.bind(view)
        val borrar= ItemNuevoBinding.bind(view).borrar
        val checked= ItemNuevoBinding.bind(view).checkBox
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
        val borrar=holder.borrar
        val checked=holder.checked

        holder.binding.nombre.text=item.nombre
        holder.binding.imagen.setImageResource(item.imagen!!)

        borrar.setOnClickListener {
            listaItem.removeAt(position)
            notifyDataSetChanged()
        }

        checked.setOnClickListener {
            if (checked.isChecked) {
                checked.isChecked = false
            } else {
                checked.isChecked = true
            }
        }
    }
}