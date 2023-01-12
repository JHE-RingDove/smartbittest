package com.smartbit.test_smartbit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EditGoodsActivity : AppCompatActivity() {
    var name: String = ""
    var amount: String = ""
    var description: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_goods)
        val nameEditText: EditText = findViewById(R.id.editTextName)
        val amountEditText: EditText = findViewById(R.id.editTextAmount)
        val descriptionEditText: EditText = findViewById(R.id.editTextDescription)

        nameEditText.setText(GoodsAdapter.NAME)
        amountEditText.setText(GoodsAdapter.AMOUNT)
        descriptionEditText.setText(GoodsAdapter.DESCRIPTION)

    }

    fun onClick(view: View) {
        updateTable(GoodsAdapter.NAME)
        startActivity(Intent(this, FirstActivity::class.java))
    }

    private fun updateTable(oldName: String) {
        val nameEditText: EditText = findViewById(R.id.editTextName)
        val amountEditText: EditText = findViewById(R.id.editTextAmount)
        val descriptionEditText: EditText = findViewById(R.id.editTextDescription)
        name = nameEditText.text.toString()
        amount = amountEditText.text.toString()
        description = descriptionEditText.text.toString()
        Toast.makeText(
            this,
            "$oldName",
//            "update goods\n" +
//                    "set name = \"$name\",\n" +
//                    "\tamount = $amount,\n" +
//                    "\tdescription = \"$description\"\n" +
//                    "where name = \"$oldName\";",
            Toast.LENGTH_LONG
        ).show()
//        val name = nameEditText.text
//        val amount = amountEditText.text
//        val description = descriptionEditText.text
        val dbHelper = DBHelper(this, null)
        val db = dbHelper.writableDatabase
//        val textTest: TextView = findViewById(R.id.textViewTest)
//        textTest.text = "update goods\n" +
//                "set name = \"$name\",\n" +
//                "\tamount = $amount,\n" +
//                "\tdescription = \"$description\"\n" +
                "where name = \"$oldName\";"
        db.execSQL("update goods\n" +
                "set name = \"$name\",\n" +
                "\tamount = $amount,\n" +
                "\tdescription = \"$description\"\n" +
                "where name = \"$oldName\";")
    }
}