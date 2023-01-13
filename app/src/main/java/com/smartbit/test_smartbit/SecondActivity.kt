package com.smartbit.test_smartbit

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class SecondActivity : AppCompatActivity() {
    private val availableURL = "https://petstore.swagger.io/v2/pet/findByStatus?status=available"
    private val pendingURL = "https://petstore.swagger.io/v2/pet/findByStatus?status=pending"
    private val soldURL = "https://petstore.swagger.io/v2/pet/findByStatus?status=sold"
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


    }
    fun onClick(v: View) {

        when (v.id) {
            R.id.button_available -> readURL(availableURL)
            R.id.button_pending -> readURL(pendingURL)
            R.id.button_sold -> readURL(soldURL)
        }
    }

    private fun readURL(url: String) {
        var result: String = ""
        thread {
            val json = try {
                URL(url).readText()
            } catch (e: Exception) {
                return@thread
            }
            runOnUiThread {
                print(json)
                result = json

                val objectMapper: ObjectMapper = ObjectMapper()
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                val listPets: MutableList<Pet> =
                    objectMapper.readValue(result, object : TypeReference<MutableList<Pet>>() {})
                val recyclerViewCategories: RecyclerView = findViewById(R.id.pets)
                val radioGroup: RadioGroup = findViewById(R.id.radio_group)
                val radioButtonId: RadioButton = findViewById(R.id.radioButton_id)
                val radioButtonName: RadioButton = findViewById(R.id.radioButton_name)
                val selected = radioGroup.checkedRadioButtonId

                if (selected == radioButtonId.id) {
                    listPets.sortBy { it.id }
                    Toast.makeText(
                        this,
                        "id",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if (selected == radioButtonName.id) {
                    listPets.sortBy { it.name }
                    Toast.makeText(
                        this,
                        "name",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                val text: EditText = findViewById(R.id.searchText)
                if (text.text.toString().trim().isNotBlank()) {
                    val petIterator = listPets.iterator()
                    if (!petIterator.equals(null)) {
                        while (petIterator.hasNext()) {
                            val tmpPet = petIterator.next()
                            if (tmpPet.name?.isNotEmpty() == true) {
                                if (!(tmpPet.name!!.uppercase()
                                        .contains(text.text.toString().uppercase()))) {
                                    petIterator.remove()
                                }
                            }
                            else {
                                petIterator.remove()
                            }
                        }
                    }
                }

                radioGroup.clearCheck()
                recyclerViewCategories.layoutManager = LinearLayoutManager(this)
                recyclerViewCategories.adapter = PetAdapter(listPets)
            }
        }

    }
}