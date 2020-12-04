package com.example.marvelcharacters.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.R
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.databinding.ItemComicBinding

class ComicAdapter(private val comics: List<Result>,
) :
    RecyclerView.Adapter<ComicAdapter.CategoryHolder>() {

    override fun getItemCount() = comics.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryHolder(
            DataBindingUtil.inflate<ItemComicBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_comic,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {

        holder.itemComicBinding.comic = comics[position]
    }

    inner class CategoryHolder(val itemComicBinding: ItemComicBinding) :
        RecyclerView.ViewHolder(itemComicBinding.root) {

    }
}