package com.example.rostislav.observerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fruit_view_holder.view.*

class FruitAdapter(val list: MutableList<Fruit>,val onChanged: (Fruit,State) -> Unit)
    : BaseAdapter<Fruit, BaseAdapter.BaseViewHolder<Fruit>>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<Fruit> {

        val view = LayoutInflater
            .from(p0.context)
            .inflate(R.layout.fruit_view_holder, p0, false)

        return FruitViewHolder(view)
    }


    override fun onBindViewHolder(holder: BaseViewHolder<Fruit>, position: Int) {

        holder.bind(list[position])

    }

    override fun getItemCount(): Int = list.size

    override fun addItem(item: Fruit) {
        list.add(item)
        notifyDataSetChanged()
        onChanged(item,State.Added)
    }

    override fun deleteItem(item: Fruit) {
        list.remove(item)
        notifyDataSetChanged()
        onChanged(item,State.Removed)
        notifyDataSetChanged()
    }


    class FruitViewHolder(item: View) : BaseAdapter.BaseViewHolder<Fruit>(item) {

        override fun bind(type: Fruit) {

            itemView.nameHolder.text = type.name
            itemView.priceHolder.text = type.price.toString()
        }
    }
}