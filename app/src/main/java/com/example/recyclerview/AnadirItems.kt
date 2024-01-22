package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class AnadirItems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_items)
        var binding= ActivityMainBinding.inflate(layoutInflater)
        val añadir=findViewById<Button>(R.id.añadir)
        var listaItem= mutableListOf<Item>()
        var listanombres= mutableListOf<String>("Javier","María","Carlos","Laura","Pedro","Ana","Miguel","Sara","David","Elena")
        var random=(0..listanombres.size).random()
        var itemAdaptador=AnadirAdapter(listaItem,this)


        añadir.setOnClickListener {
            var newItem=Item(listanombres.get(random),R.drawable.gorila)
            listaItem.add(newItem)
            itemAdaptador=AnadirAdapter(listaItem,this)
            binding.recyclerView.apply {
                layoutManager= LinearLayoutManager(this@AnadirItems)
                adapter=itemAdaptador
                println("hola")
                adapter!!.notifyDataSetChanged()
            }
        }


    }
}