package com.poilkar.nehank.paging3_networkonly.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poilkar.nehank.paging3_networkonly.databinding.RowLoaderBinding
import com.poilkar.nehank.paging3_networkonly.databinding.RowPhotoBinding

class PictureLoaderAdapter : LoadStateAdapter<PictureLoaderAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: RowLoaderBinding) : RecyclerView.ViewHolder(binding.rootLayout) {

        fun bind(loadState : LoadState){
            binding.progressBar.isVisible = loadState is LoadState.Loading
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): MyViewHolder {
        val binding = RowLoaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
}