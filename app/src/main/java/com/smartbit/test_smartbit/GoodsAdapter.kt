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


class GoodsAdapter(private val names: MutableList<GoodsItem>) : RecyclerView
.Adapter<GoodsAdapter.ViewHolder>() {

    companion object {
        var ID: Int = 0
        var NAME: String = "NAME!"
        var AMOUNT: String = "AMOUNT!"
        var DESCRIPTION: String = "DESCRIPTION!"
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonDelete: Button = itemView.findViewById(R.id.button_delete)
        val buttonEdit: Button = itemView.findViewById(R.id.button_edit)
        val name: TextView = itemView.findViewById(R.id.goodName)
        val amount: TextView = itemView.findViewById(R.id.amount)
        val description: TextView = itemView.findViewById(R.id.description)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.goods_item_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.goods_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = names[position].name
        viewHolder.amount.text = names[position].amount.toString()
        viewHolder.description.text = names[position].description
        viewHolder.constraintLayout.setOnClickListener { view ->
            Toast.makeText(
                view.context,
                "click on item: $position",
                Toast.LENGTH_SHORT
            ).show()
        }
        viewHolder.buttonEdit.setOnClickListener{ view ->
            val intent = Intent(viewHolder.constraintLayout.context, EditGoodsActivity::class.java)

            ID = position
            NAME = names[position].name
            AMOUNT = names[position].amount.toString()
            DESCRIPTION = names[position].description
            viewHolder.constraintLayout.context.startActivity(intent)

        }
        viewHolder.buttonDelete.setOnClickListener{ view ->
            removeAt(viewHolder.name, position)
        }

    }

    override fun getItemCount() = names.size

//    private fun getID(name: String) {
//
//    }
    private fun removeAt(name: TextView, position: Int) {
        names.removeAt(position)
        notifyDataSetChanged()
//        val dbHelper = DBHelper(name.context, null)
//        val db = dbHelper.writableDatabase
//        db.execSQL("delete from goods where name = " + "\"" + name.text + "\"")
//        notifyItemChanged(position)
//        notifyItemRemoved(position)
//        notifyItemRangeRemoved(position, 1)
//        notifyItemRemoved(position)
//        if (position == itemCount) {
//            notifyItemRangeChanged(position, names.size-1)
//
//        }
//        else {
//            notifyItemRangeChanged(position, names.size)
//        }
//        notifyItemRangeChanged(position, 1)
//        notifyItemRangeRemoved(position, 1)
    }
}