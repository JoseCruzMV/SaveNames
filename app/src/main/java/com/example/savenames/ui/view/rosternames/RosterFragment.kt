package com.example.savenames.ui.view.rosternames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.savenames.R
import com.example.savenames.databinding.RosterFragmentLayoutBinding
import com.example.savenames.ui.viewmodel.NameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RosterFragment : Fragment(R.layout.roster_fragment_layout) {
    private lateinit var binding: RosterFragmentLayoutBinding
    private val nameViewModel: NameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = RosterFragmentLayoutBinding.inflate(inflater, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NamesRosterAdapter(inflater = layoutInflater)
        binding.rosterNames.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }

        nameViewModel.getAllNames()

        nameViewModel.namesList.observe(viewLifecycleOwner) { currentNamesList ->
            adapter.submitList(currentNamesList.map { it.name })
        }
    }
}