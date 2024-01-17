package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class Ajedrez : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var ajedrezAdaptador: AjedrezAdaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajedrez)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

        ajedrezAdaptador=AjedrezAdaptador(data)

        binding.recyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=ajedrezAdaptador
        }

        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
}