package com.buranchikov.sevenwindsstudiotest.fragments.list_menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Product
import com.buranchikov.sevenwindsstudiotest.data_classes.Order
import com.buranchikov.sevenwindsstudiotest.databinding.MenuItemBinding
import com.squareup.picasso.Picasso

class ProductListAdapter : ListAdapter<Product, ProductListAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = MenuItemBinding.bind(view)
        var count: Int =0
        val listOrder = mutableListOf<Order>()



        fun countProduct(){
            binding.ivMinusMenuItem.setOnClickListener {
                --count
                if (count < 0) count = 0
                binding.tvCountMenuItem.text = count.toString()
            }
            binding.ivPlusMenuItem.setOnClickListener {
                ++count
                if (count > 100) count = 100
                binding.tvCountMenuItem.text = count.toString()
            }
        }




        fun bind(coffeeMenu: Product) {
            Picasso.get().load(coffeeMenu.imageURL).into(binding.ivProductPhotoItem)
            if (coffeeMenu.name.startsWith("https")) {
                binding.tvMenuNameItem.text = "Капучино"
            } else {
                binding.tvMenuNameItem.text = coffeeMenu.name
            }
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
        holder.countProduct()
    }

    class Comparator() : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }


    }

}