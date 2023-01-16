package com.smartbit.test_smartbit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateGoodsActivity : AppCompatActivity() {
    var name: String = ""
    var amount: String = ""
    var description: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_goods)

    }

    fun onClick(view: View) {
        insert(GoodsAdapter.NAME)
        startActivity(Intent(this, FirstActivity::class.java))
    }

    private fun insert(oldName: String) {
        val nameEditText: EditText = findViewById(R.id.editTextName)
        val amountEditText: EditText = findViewById(R.id.editTextAmount)
        val descriptionEditText: EditText = findViewById(R.id.editTextDescription)
        name = nameEditText.text.toString()
        amount = amountEditText.text.toString()
        description = descriptionEditText.text.toString()
        MainActivity.GOODSLIST.add(GoodsItem(name, amount.toInt(),description))
//        Toast.makeText(
//            this,
//            "$oldName",
//            Toast.LENGTH_LONG
//        ).show()

//        val dbHelper = DBHelper(this, null)
//        val db = dbHelper.writableDatabase
//
//        db.execSQL("insert into goods (name, amount, description) values\n" +
//                "(\"$name\", $amount, \"$description\");")
    }

}