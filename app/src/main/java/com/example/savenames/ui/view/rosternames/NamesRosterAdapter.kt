package com.example.savenames.ui.view.rosternames

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.savenames.databinding.RosterNamesItemBinding


class NamesRosterAdapter(
    private val inflater: LayoutInflater,
) : ListAdapter<String, RosterRowHolder>(DIffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = RosterRowHolder(
        RosterNamesItemBinding.inflate(inflater, parent, false)
    )

    override fun onBindViewHolder(holder: RosterRowHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class RosterRowHolder(
    private val binding: RosterNamesItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) = binding.apply { itemName.text = name }
}

private object DIffCallBack: DiffUtil.ItemCallback<String>() {
    override fun areContentsTheSame(oldItem: String, newItem: String) =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: String, newItem: String) =
        oldItem == newItem
}
