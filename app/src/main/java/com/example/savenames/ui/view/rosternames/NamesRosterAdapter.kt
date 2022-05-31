package com.example.savenames.ui.view.rosternames

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.savenames.databinding.RosterNamesItemBinding
import com.example.savenames.domain.model.Name


class NamesRosterAdapter(
    private val inflater: LayoutInflater,
    private val onRowClick: (Name) -> Unit,
) : ListAdapter<Name, RosterRowHolder>(DIffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = RosterRowHolder(
        RosterNamesItemBinding.inflate(inflater, parent, false),
        onRowClick = onRowClick
    )

    override fun onBindViewHolder(holder: RosterRowHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class RosterRowHolder(
    private val binding: RosterNamesItemBinding,
    val onRowClick: (Name) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(givenName: Name) =
        binding.apply {
            itemName.text = givenName.name
            root.setOnLongClickListener {
                onRowClick(givenName)
                true
            }
        }
}

private object DIffCallBack : DiffUtil.ItemCallback<Name>() {
    override fun areContentsTheSame(oldItem: Name, newItem: Name) =
        oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: Name, newItem: Name) =
        oldItem.name == newItem.name
}
