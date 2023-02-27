package com.example.melimarketplace.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.melimarketplace.databinding.FragmentSlidePhotoBinding
import com.example.melimarketplace.ui.fragment.OnboardingSlideItemFragment.Companion.IMAGE_RESOURCE_BUNDLE
import com.example.melimarketplace.ui.model.PictureViewData

class OnboardingSlideItemFragment : Fragment(), ViewPager2.PageTransformer {

    private var binding: FragmentSlidePhotoBinding? = null

    companion object {
        const val IMAGE_RESOURCE_BUNDLE = "imageResource"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSlidePhotoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null


    }

    private fun initViews() {
        val args = arguments
        if (args != null && args.containsKey(IMAGE_RESOURCE_BUNDLE)) {
            binding?.apply {
                ivImage.load(args.getString(IMAGE_RESOURCE_BUNDLE)) {
                    crossfade(true)
                }
            }
        }
    }

    override fun transformPage(page: View, position: Float) {}
}

class MyPagerOnboardingSlide(
    fragmentActivity: FragmentActivity,
    private val list: List<PictureViewData>
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment
        fragment = OnboardingSlideItemFragment()
        val args = Bundle()
        args.putString(IMAGE_RESOURCE_BUNDLE, list[position].imageUrl)
        fragment.setArguments(args)
        return fragment
    }

    override fun getItemCount(): Int = list.size
}