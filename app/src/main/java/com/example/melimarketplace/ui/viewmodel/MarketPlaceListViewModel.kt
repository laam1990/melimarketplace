package com.example.melimarketplace.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.melimarketplace.domain.repository.MarketPlaceRepository
import com.example.melimarketplace.ui.model.ResultItemViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketPlaceListViewModel @Inject constructor(private val repository: MarketPlaceRepository) :
    ViewModel() {

    private val _marketPlaceItemsLiveData =
        MutableLiveData<PagingData<ResultItemViewData>>()
    val marketPlaceItemsLiveData: LiveData<PagingData<ResultItemViewData>> =
        _marketPlaceItemsLiveData

    fun getProducts(query: String) {
        viewModelScope.launch {
            repository.getListItems(query).cachedIn(viewModelScope).collect {
                    _marketPlaceItemsLiveData.value = it
                }
        }
    }
}