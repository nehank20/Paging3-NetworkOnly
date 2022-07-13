package com.poilkar.nehank.paging3_networkonly.paging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poilkar.nehank.paging3_networkonly.R
import com.poilkar.nehank.paging3_networkonly.databinding.RowPhotoBinding
import com.poilkar.nehank.paging3_networkonly.model.Pictures

class PicturePagingAdapter(private val context: Context) :
    PagingDataAdapter<Pictures.Hit, PicturePagingAdapter.MyViewHolder>(
        COMPARATOR
    ) {


    class MyViewHolder(val binding: RowPhotoBinding) : RecyclerView.ViewHolder(binding.rootLayout) {

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.binding.apply {
                appCompatTextView.text = currentItem.user
                Glide.with(context).load(currentItem.largeImageURL)
                    .placeholder(R.drawable.ic_placeholder_img).into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Pictures.Hit>() {
            override fun areItemsTheSame(oldItem: Pictures.Hit, newItem: Pictures.Hit): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Pictures.Hit, newItem: Pictures.Hit): Boolean {
                return oldItem == newItem
            }
        }
    }
}