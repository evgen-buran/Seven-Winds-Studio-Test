package com.buranchikov.sevenwindsstudiotest.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.CoffeeMenu
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.databinding.ListItemBinding

class CoffeeListAdapter : ListAdapter<Location, CoffeeListAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)


        fun bind(location: Location) {
            binding.tvNameCoffeeItem.text = location.name
            binding.tvDistanceItem.text = "1 км от вас"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}

class Comparator : DiffUtil.ItemCallback<Location>() {
    override fun areItemsTheSame(oldItem: Location, newItem:Location): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem == newItem
    }

}

