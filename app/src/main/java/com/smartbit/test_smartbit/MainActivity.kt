package com.smartbit.test_smartbit

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        var GOODSLIST: MutableList<GoodsItem> = mutableListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        GOODSLIST = getListGoods()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val dbHelper = DBHelper(this, null)
//        val db = dbHelper.writableDatabase
//
//        val cursor: Cursor = db.rawQuery("Select * from goods;", null)
//
//        print("-----------------------------------------")
//
//        cursor.moveToFirst()


    }
    private fun getListGoods(): MutableList<GoodsItem> {

        val names = mutableListOf<GoodsItem>()
        names.add(GoodsItem ("Molotok", 11, "desc"))
        names.add(GoodsItem ("Prikol", 12, "desc"))
        names.add(GoodsItem ("Tritiy", 13, "desc"))
        names.add(GoodsItem ("Grecha", 14, "desc"))
        names.add(GoodsItem ("Baranki", 51, "desc"))
        names.add(GoodsItem ("Pizza", 16, "desc"))
        names.add(GoodsItem ("Burger", 71, "desc"))
        names.add(GoodsItem ("Lol", 18, "desc"))
        names.add(GoodsItem ("Kek", 19, "desc"))
        names.add(GoodsItem ("Predposledniy", 100, "desc"))
        names.add(GoodsItem ("Zhelud'", 111, "desc"))
        return names
    }
    fun onClick(v: View) {
        when (v.id) {
            R.id.button_first -> startActivity(Intent(this, FirstActivity::class.java))
            R.id.button_second -> startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}