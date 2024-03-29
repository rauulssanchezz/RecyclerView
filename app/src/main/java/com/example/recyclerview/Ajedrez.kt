package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityAjedrezBinding
import com.example.recyclerview.databinding.ActivityMainBinding

class Ajedrez : AppCompatActivity() {
    private lateinit var binding : ActivityAjedrezBinding
    private lateinit var ajedrezAdaptador: AjedrezAdaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAjedrezBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton = findViewById<Button>(R.id.boton)

        val data = mutableListOf(
            Ficha("Javier"),
            Ficha("María"),
            Ficha("Carlos"),
            Ficha("Laura"),
            Ficha("Pedro"),
            Ficha("Ana"),
            Ficha("Miguel"),
            Ficha("Sara"),
            Ficha("David"),
            Ficha("Elena")
        )

        boton.setOnClickListener {
            var newIntent= Intent(this,AnadirItems::class.java)
            startActivity(newIntent)
        }

        ajedrezAdaptador=AjedrezAdaptador(data)

        binding.recyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=ajedrezAdaptador
        }

        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
}