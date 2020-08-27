package com.techdining.www.wallpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techdining.www.wallpage.adapter.HomePageAdapter.HomePageViewHolder
import com.techdining.www.wallpage.dataModel.PhotoItems
import com.techdining.www.wallpage.databinding.ItemViewBinding

class HomePageAdapter : PagingDataAdapter<PhotoItems, HomePageViewHolder>(PHOTO_ITEMS_COMPARATOR) {
    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        return HomePageViewHolder.create(parent)
    }

    companion object {
        private val PHOTO_ITEMS_COMPARATOR = object : DiffUtil.ItemCallback<PhotoItems>() {
            override fun areItemsTheSame(oldItem: PhotoItems, newItem: PhotoItems): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PhotoItems, newItem: PhotoItems): Boolean =
                oldItem == newItem
        }
    }

    class HomePageViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PhotoItems) {
            binding.apply {
                photo = item
                executePendingBindings()
            }
        }

        companion object {
            fun create(parent: ViewGroup): HomePageViewHolder {
                return HomePageViewHolder(
                    ItemViewBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }
}
