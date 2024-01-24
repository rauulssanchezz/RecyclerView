package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityAnadirItemsBinding

class AnadirItems : AppCompatActivity() {
    private lateinit var listaItem: MutableList<Item>
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var listaChecked: MutableList<Item>
    private lateinit var binding: ActivityAnadirItemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val añadir = findViewById<Button>(R.id.añadir)
        listaChecked = mutableListOf<Item>()
        listaItem = mutableListOf<Item>()
        var listanombres = mutableListOf<String>(
            "Javier",
            "María",
            "Carlos",
            "Laura",
            "Pedro",
            "Ana",
            "Miguel",
            "Sara",
            "David",
            "Elena"
        )
        var random = (0..listanombres.size).random()
        var itemAdaptador: AnadirAdapter

        añadir.setOnClickListener {
            random = (0..listanombres.size - 1).random()
            var newItem = Item(listanombres.get(random), R.drawable.gorila)
            listaItem.add(newItem)
            itemAdaptador = AnadirAdapter(listaItem, this)

            binding.anadirView.apply {
                layoutManager = LinearLayoutManager(this@AnadirItems)
                adapter = itemAdaptador
                adapter!!.notifyDataSetChanged()
            }

        }
        binding.anadirViewCheck.apply {
            layoutManager = LinearLayoutManager(this@AnadirItems)
            adapter = AnadirAdapter(listaChecked, this@AnadirItems)
            adapter!!.notifyDataSetChanged()
        }
        startCheckingThread()
    }

        private fun startCheckingThread() {
            handler.post(object : Runnable {
                override fun run() {
                    checkItems()
                    handler.postDelayed(this, 16) // 16 ms = 1/60 s
                }
            })
        }

        private fun checkItems() {
            val iterator = listaItem.iterator()
            while (iterator.hasNext()) {
                val item = iterator.next()

                if (item.check && !item.isChecked) {
                    // Haz algo si el item está marcado
                    item.isChecked = true
                    listaChecked.add(item)
                    iterator.remove()
                    binding.anadirViewCheck.apply {
                        layoutManager = LinearLayoutManager(this@AnadirItems)
                        adapter!!.notifyDataSetChanged()
                    }
                    binding.anadirView.apply {
                        layoutManager = LinearLayoutManager(this@AnadirItems)
                        adapter!!.notifyDataSetChanged()
                    }
                }
            }
    }
}