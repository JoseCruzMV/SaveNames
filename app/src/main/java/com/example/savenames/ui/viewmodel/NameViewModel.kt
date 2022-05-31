package com.example.savenames.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savenames.domain.DeleteNameUseCase
import com.example.savenames.domain.GetAllNamesUseCase
import com.example.savenames.domain.SaveNameUseCase
import com.example.savenames.domain.model.Name
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val saveNameUseCase: SaveNameUseCase,
    private val getAllNamesUseCase: GetAllNamesUseCase,
    private val deleteNameUseCase: DeleteNameUseCase,
) : ViewModel() {
    val namesList = MutableLiveData<List<Name>>()

    fun saveName(name: String) {
        viewModelScope.launch {
            saveNameUseCase(name)
        }
    }

    fun getAllNames() {
        viewModelScope.launch {
            val result = getAllNamesUseCase()
            if (!result.isNullOrEmpty()) {
                namesList.postValue(result)
            } else {
                namesList.postValue(emptyList())
            }
        }
    }

    fun deleteName(name: Name) {
        viewModelScope.launch {
            deleteNameUseCase(name)
            getAllNames()
        }
    }
}