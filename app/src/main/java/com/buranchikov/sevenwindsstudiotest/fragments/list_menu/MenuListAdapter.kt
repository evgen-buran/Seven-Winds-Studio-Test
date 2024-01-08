package com.buranchikov.sevenwindsstudiotest.fragments.list_menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.CoffeeMenu
import com.buranchikov.sevenwindsstudiotest.databinding.MenuItemBinding
import com.squareup.picasso.Picasso

class MenuListAdapter : ListAdapter<CoffeeMenu, MenuListAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = MenuItemBinding.bind(view)

        fun bind(coffeeMenu: CoffeeMenu) {
            Picasso.get().load(coffeeMenu.imageURL).into(binding.ivProductPhotoItem)
            binding.tvMenuNameItem.text = coffeeMenu.name
            binding.tvMenuPriceItem.text = coffeeMenu.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return Holder(view)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Comparator() : DiffUtil.ItemCallback<CoffeeMenu>() {
        override fun areItemsTheSame(oldItem: CoffeeMenu, newItem: CoffeeMenu): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CoffeeMenu, newItem: CoffeeMenu): Boolean {
            return oldItem == newItem
        }


    }

}