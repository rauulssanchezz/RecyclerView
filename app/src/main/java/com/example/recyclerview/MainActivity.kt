package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var contactoAdapter: ContactoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = mutableListOf(
            Contacto("Javier", "tupeine..2Aj@gmail.com", 678897643),
            Contacto("María", "maria@gmail.com", 123456789),
            Contacto("Carlos", "carlos@yahoo.com", 987654321),
            Contacto("Laura", "laura@hotmail.com", 654321098),
            Contacto("Pedro", "pedro@gmail.com", 567890123),
            Contacto("Ana", "ana@yahoo.com", 876543210),
            Contacto("Miguel", "miguel@hotmail.com", 210987654),
            Contacto("Sara", "sara@gmail.com", 789012345),
            Contacto("David", "david@yahoo.com", 543210987),
            Contacto("Elena", "elena@hotmail.com", 890123456)
        )

        contactoAdapter=ContactoAdapter(data,this)

        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=contactoAdapter
        }
    }

    fun siguiente(view: View) {
        var newIntent= Intent(this,Ajedrez::class.java)
        startActivity(newIntent)
    }
}