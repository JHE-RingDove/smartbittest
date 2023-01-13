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
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this, null)
        val db = dbHelper.writableDatabase

        val cursor: Cursor = db.rawQuery("Select * from goods;", null)

        print("-----------------------------------------")

        cursor.moveToFirst()


    }
    fun onClick(v: View) {
        when (v.id) {
            R.id.button_first -> startActivity(Intent(this, FirstActivity::class.java))
            R.id.button_second -> startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}