package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.R
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.model.Phrase
import kotlinx.android.synthetic.main.row_phrase.view.*

class MainAdapter(private val data: ArrayList<Phrase> = arrayListOf()):
    RecyclerView.Adapter<MainAdapter.MyHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.row_phrase, p0, false)

        return MyHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind( data[position])
    }

    fun add(phrase: Phrase){
        data.add( phrase)
        notifyDataSetChanged()
    }

    fun addAll(phrases: List<Phrase>){
        data.addAll( phrases)
        notifyDataSetChanged()
    }

    class MyHolder(private val v: View): RecyclerView.ViewHolder(v){
        fun bind(item: Phrase){
            with(v){
                tv_phrase.text = item.text
            }
        }
    }


}