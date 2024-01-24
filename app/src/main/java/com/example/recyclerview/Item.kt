package com.example.recyclerview

data class Item(
    var nombre:String,
    var imagen:Int?=R.drawable.gorila,
    var check:Boolean=false,
    var isChecked:Boolean=false
) {
}