package com.buranchikov.sevenwindsstudiotest.fragments.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Order
import com.buranchikov.sevenwindsstudiotest.databinding.OrderItemBinding

class OrderAdapter : ListAdapter<Order, OrderAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = OrderItemBinding.bind(view)
        var count: Int = 0
        var price: Int = 0
        fun bind(order: Order) {
            count = order.count
            price = order.product.price
            if (order.product.name.startsWith("https")) {
                binding.tvNameCoffeeOrderItem.text = "Капучино"
            } else {
                binding.tvNameCoffeeOrderItem.text = order.product.name
            }
            binding.tvCountOrderItem.text = order.count.toString()
            binding.tvPriceOrderItem.text = order.product.price.toString()
        }

        fun countProduct() {
            binding.ivMinusOrderItem.setOnClickListener {
                --count
                if (count < 0) count = 0
                binding.tvCountOrderItem.text = count.toString()

            }
            binding.ivPlusOrderItem.setOnClickListener {
                ++count
                if (count > 100) count = 100
                binding.tvCountOrderItem.text = count.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
        holder.countProduct()
    }

    class Comparator : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem
        }
    }

}
















