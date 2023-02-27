package com.example.melimarketplace.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.melimarketplace.data.util.Resource
import com.example.melimarketplace.domain.repository.MarketPlaceRepository
import com.example.melimarketplace.ui.model.DetailViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketPlaceDetailViewModel @Inject constructor(private val repository: MarketPlaceRepository) :
    ViewModel() {

    private val _marketPlaceDetailLiveData =
        MutableLiveData<Resource<DetailViewData>>()

    val marketPlaceDetailLiveData: LiveData<Resource<DetailViewData>> =
        _marketPlaceDetailLiveData

    fun getMarketPlaceDetail(id: String) {
        viewModelScope.launch {
            repository.getDetail(id).collect {
                _marketPlaceDetailLiveData.value = it
            }
        }
    }
}