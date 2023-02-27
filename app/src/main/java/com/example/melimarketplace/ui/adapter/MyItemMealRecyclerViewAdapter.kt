package com.example.melimarketplace.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.melimarketplace.R
import com.example.melimarketplace.databinding.ItemProductBinding
import com.example.melimarketplace.ui.model.ResultItemViewData

class MyItemRecyclerViewAdapter :
    PagingDataAdapter<ResultItemViewData, MyItemRecyclerViewAdapter.MyViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ResultItemViewData>() {
            override fun areItemsTheSame(
                oldItem: ResultItemViewData,
                newItem: ResultItemViewData
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResultItemViewData,
                newItem: ResultItemViewData
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    var onItemClick: ((ResultItemViewData) -> Unit)? = null

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val products = getItem(position)
        products?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binding, onItemClick)
    }

    inner class MyViewHolder(
        private val binding: ItemProductBinding,
        private val onItemClick: ((item: ResultItemViewData) -> Unit)? = null
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultItemViewData) {
            binding.apply {
                clContainer.setOnClickListener {
                    onItemClick?.invoke(item)
                }
                ivProduct.load(item.imageUrl) {
                    crossfade(true)
                }
                tvProductName.text = item.productName
                tvProductPrice.text =
                    binding.root
                    .context
                    .getString(R.string.item_price, item.price)
            }
        }
    }
}