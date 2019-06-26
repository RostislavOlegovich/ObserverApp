package com.example.rostislav.observerapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class BaseAdapter <M, VH : BaseAdapter.BaseViewHolder<M>> : RecyclerView.Adapter<VH>() {

    abstract override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VH

    abstract override fun getItemCount(): Int

    abstract override fun onBindViewHolder(holder: VH, position: Int)

    abstract fun addItem(item: M)

    abstract fun deleteItem(item: M)

    abstract class BaseViewHolder<M>(item: View) : RecyclerView.ViewHolder(item) {

        abstract fun bind(type: M)

    }

}