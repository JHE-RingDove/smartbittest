package com.smartbit.test_smartbit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class PetAdapter(private val names: MutableList<Pet>) : RecyclerView
.Adapter<PetAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.namePet)
        val id: TextView = itemView.findViewById(R.id.idPet)
        val status: TextView = itemView.findViewById(R.id.statusPet)
        val category: TextView = itemView.findViewById(R.id.categoryPet)
        val tags: TextView = itemView.findViewById(R.id.tagsPet)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.pet_item_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = names[position].name
        viewHolder.id.text = names[position].id.toString()
        viewHolder.status.text = names[position].status
        if (names[position].category != null) {
            for (categoryName: Pet.Category in names[position].category!!) {
                viewHolder.category.append(categoryName.name+"\n")
            }
        }
        if (names[position].tags != null) {
            for (tagName: Pet.Tag in names[position].tags!!) {
                viewHolder.tags.append(tagName.name+"\n")
            }
        }

    }

    override fun getItemCount() = names.size
}

