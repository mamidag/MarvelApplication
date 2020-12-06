package com.example.marvelcharacters.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.R
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.databinding.ItemCharacterBinding
import com.example.marvelcharacters.listener.IListener


class CharactersAdapter(val itemClickListener: IListener<Result>) :

    PagingDataAdapter<Result, CharactersAdapter.CategoryHolder>(MovieComparator) {


    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.recyclerviewChracterBinding.resultData = getItem(position)

        holder.bind(getItem(position)!!, itemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryHolder(
            DataBindingUtil.inflate<ItemCharacterBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_character,
                parent,
                false
            )
        )


    class CategoryHolder(val recyclerviewChracterBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(recyclerviewChracterBinding.root) {

        fun bind(result: Result, clickListener: IListener<Result>) {
            recyclerviewChracterBinding.btnDetail.setOnClickListener {
                clickListener.onClick(result)

/*
                it.navigateSafe(R.id.action_charactersFragment_to_characterDetailFragment)
*/
            }
        }
    }

    object MovieComparator : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            // Id is unique.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
}



