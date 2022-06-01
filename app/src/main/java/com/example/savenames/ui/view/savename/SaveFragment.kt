package com.example.savenames.ui.view.savename

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.savenames.R
import com.example.savenames.databinding.SaveFragmentLayoutBinding
import com.example.savenames.ui.viewmodel.NameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment(R.layout.save_fragment_layout) {
    private lateinit var binding: SaveFragmentLayoutBinding
    private val nameViewModel: NameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = SaveFragmentLayoutBinding.inflate(inflater, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            bSave.setOnClickListener {
                nameViewModel.saveName(etName.editText?.text.toString())
                etName.editText?.text?.clear()
            }
        }
    }
}