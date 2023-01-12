package com.smartbit.test_smartbit

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val recyclerViewCategories: RecyclerView = findViewById(R.id.goods)
        recyclerViewCategories.layoutManager = LinearLayoutManager(this)
        recyclerViewCategories.adapter = GoodsAdapter(getListGoods())
    }

    private fun getListGoods(): MutableList<GoodsItem> {

        val names = mutableListOf<GoodsItem>()
        val dbHelper = DBHelper(this, null)
        val db = dbHelper.writableDatabase
        val cursor: Cursor = db.rawQuery("Select * from goods;", null)
        var name: String
        var amount: Int
        var description: String
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            name = cursor.getString(1)
            amount = cursor.getInt(2)
            description = cursor.getString(3)
            names.add(GoodsItem (name, amount, description))
            cursor.moveToNext()
        }
//        names.add(GoodsItem ("Molotok", 1, "desc"))
//        names.add(GoodsItem ("Prikol", 1, "desc"))
//        names.add(GoodsItem ("Tritiy", 1, "desc"))
//        names.add(GoodsItem ("Grecha", 1, "desc"))
//        names.add(GoodsItem ("Baranki", 1, "desc"))
//        names.add(GoodsItem ("Pizza", 1, "desc"))
//        names.add(GoodsItem ("Burger", 1, "desc"))
//        names.add(GoodsItem ("Lol", 1, "desc"))
//        names.add(GoodsItem ("Kek", 1, "desc"))
//        names.add(GoodsItem ("Predposledniy", 1, "desc"))
//        names.add(GoodsItem ("Zhelud'", 1, "desc"))
//        names.removeAt(2)
        return names
    }
    fun onClick(v: View) {
        when (v.id) {
            R.id.button_create -> startActivity(Intent(this, CreateGoodsActivity::class.java))
        }
    }
}