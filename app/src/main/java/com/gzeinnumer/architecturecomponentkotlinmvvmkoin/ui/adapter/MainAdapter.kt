package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.R
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.CategoriesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(private val item: List<CategoriesItem>,
                  private val listener: (CategoriesItem) -> Unit):
    RecyclerView.Adapter<MainAdapter.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(categoriesItem: CategoriesItem, listener: (CategoriesItem) -> Unit) {
            itemView.tvTitle.text = categoriesItem.strCategory
            itemView.tvDeskripsi.text = categoriesItem.strCategoryDescription
            Picasso.get().load(categoriesItem.strCategoryThumb).into(itemView.ivImage)

            itemView.setOnClickListener {
                listener(categoriesItem)
            }
        }
    }


}