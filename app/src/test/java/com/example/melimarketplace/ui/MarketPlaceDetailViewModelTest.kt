package com.example.melimarketplace.ui

import androidx.lifecycle.Observer
import com.example.melimarketplace.BaseUnitTest
import com.example.melimarketplace.data.util.Resource
import com.example.melimarketplace.getOrAwaitValueTest
import com.example.melimarketplace.repository.MarketPlaceFakeRepository
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.viewmodel.MarketPlaceDetailViewModel
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.refEq

class MarketPlaceDetailViewModelTest : BaseUnitTest() {
    private lateinit var viewModel: MarketPlaceDetailViewModel
    private lateinit var repository: MarketPlaceFakeRepository

    companion object {
        const val ID_PRODUCT = "MLA1318177291"
    }

    @Mock
    lateinit var marketPlaceDetailObserver: Observer<Resource<DetailViewData>>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = MarketPlaceFakeRepository()
        viewModel = MarketPlaceDetailViewModel(repository)
        viewModel.apply {
            this.marketPlaceDetailLiveData.observeForever(marketPlaceDetailObserver)
        }
    }

    @Test
    fun `should change to loading state - when get marketplace detail is called`() = runTest {
            repository.setWillReturnError(false)
            viewModel.getMarketPlaceDetail(ID_PRODUCT)

            verify(marketPlaceDetailObserver).onChanged(refEq(Resource.Loading()))
        }

    @Test
    fun `should change to error state - when get detail meal is called`() {
        repository.setWillReturnError(true)

        viewModel.getMarketPlaceDetail(ID_PRODUCT)

        val value = viewModel.marketPlaceDetailLiveData.getOrAwaitValueTest()

        Truth.assertThat(value is Resource.Error).isTrue()
    }

    @Test
    fun `should change to success state - when get detail meal is called`() {
        viewModel.getMarketPlaceDetail(ID_PRODUCT)

        val value = viewModel.marketPlaceDetailLiveData.getOrAwaitValueTest()

        Truth.assertThat(value is Resource.Success).isTrue()
    }
}