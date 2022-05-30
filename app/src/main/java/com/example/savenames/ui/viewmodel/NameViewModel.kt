package com.example.savenames.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savenames.domain.SaveNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val saveNameUseCase: SaveNameUseCase,
) : ViewModel() {
    fun saveName(name: String) {
        viewModelScope.launch {
            saveNameUseCase.invoke(name)
        }
    }
}