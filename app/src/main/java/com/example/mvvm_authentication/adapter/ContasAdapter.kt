package com.example.mvvm_authentication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_authentication.R
import com.example.mvvm_authentication.model.Conta

class ContasAdapter : RecyclerView.Adapter<ContaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_conta, parent, false)
        return ContaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        listOfContas[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfContas.size

    fun refresh(newList: List<Conta>) {
        listOfContas = arrayListOf()
        listOfContas.addAll(newList)
        notifyDataSetChanged()
    }

}

class ContaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(conta: Conta) {
        setData(conta.uid, R.id.uidTextView)
        setData(conta.name, R.id.nametextView)
        setData(conta.price.toString(), R.id.priceTextView)

    }
    private fun setData(value: String?, @IdRes componentId: Int) {
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }

}