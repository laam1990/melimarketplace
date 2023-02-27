package com.example.melimarketplace.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.melimarketplace.R
import com.example.melimarketplace.data.util.Resource
import com.example.melimarketplace.databinding.FragmentMarketPlaceDetailBinding
import com.example.melimarketplace.ui.extensions.gone
import com.example.melimarketplace.ui.extensions.visible
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.viewmodel.MarketPlaceDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceDetailFragment : Fragment() {

    private var binding: FragmentMarketPlaceDetailBinding? = null
    private val viewModel: MarketPlaceDetailViewModel by viewModels()
    private val args: MarketPlaceDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketPlaceDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        viewModel.getMarketPlaceDetail(args.id)
    }

    private fun initObservers() {
        viewModel.marketPlaceDetailLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Error -> showErrorView()
                is Resource.Loading -> showLoadingView()
                is Resource.Success -> showSuccessView(result.data)
            }
        }
    }

    private fun showLoadingView() {
        binding?.apply {
            groupContent.gone()
            progressBar.visible()
        }
    }

    private fun showSuccessView(data: DetailViewData?) {
        data?.let {
            binding?.apply {
                groupContent.visible()
                progressBar.gone()

                tvCondition.text = data.condition
                tvTitle.text = data.title
                tvPrice.text = getString(R.string.item_price, data.price)

                //setup viewpager
                val pagerAdapter = MyPagerOnboardingSlide(
                    requireActivity(),
                    data.pictures
                )

                vpProduct.adapter = pagerAdapter
                vpProduct.setPageTransformer(OnboardingSlideItemFragment())
                pagerIndicator.setViewPager2(vpProduct)
            }
        } ?: showErrorView()
    }

    private fun showErrorView() {
        binding?.apply {
            groupContent.gone()
            progressBar.gone()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}