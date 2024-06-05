package com.github.juliocesarlb.alunoResponsavel_rm94543.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.juliocesarlb.alunoResponsavel_rm94543.R
import com.github.juliocesarlb.alunoResponsavel_rm94543.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()


    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPraia = view.findViewById<TextView>(R.id.textViewPraia)
        val textViewCidade = view.findViewById<TextView>(R.id.textViewCidade)
        val textViewEstado = view.findViewById<TextView>(R.id.textViewEstado)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: ItemModel) {
            textViewPraia.text = item.praia
            textViewCidade.text= item.cidade
            textViewEstado.text= item.estado

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }}