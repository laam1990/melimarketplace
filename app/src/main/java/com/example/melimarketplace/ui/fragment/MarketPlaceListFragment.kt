package com.example.melimarketplace.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.melimarketplace.R
import com.example.melimarketplace.databinding.FragmentMarketPlaceListBinding
import com.example.melimarketplace.ui.adapter.MyItemLoadStateAdapter
import com.example.melimarketplace.ui.adapter.MyItemRecyclerViewAdapter
import com.example.melimarketplace.ui.viewmodel.MarketPlaceListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceListFragment : Fragment() {

    private var binding: FragmentMarketPlaceListBinding? = null
    private val viewModel: MarketPlaceListViewModel by viewModels()
    private var listener: MarketPlaceListListener? = null
    private val itemRecyclerViewAdapter by lazy { MyItemRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketPlaceListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        setupMenu()
        binding?.apply {
            binding?.rvProducts?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )
                adapter = itemRecyclerViewAdapter.withLoadStateHeaderAndFooter(
                    header = MyItemLoadStateAdapter { itemRecyclerViewAdapter.retry() },
                    footer = MyItemLoadStateAdapter { itemRecyclerViewAdapter.retry() }
                )
            }

            itemRecyclerViewAdapter.onItemClick = { item ->
                listener?.goToDetail(item.id)
            }
        }
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {

            override fun onPrepareMenu(menu: Menu) {
                // Handle for example visibility of menu items
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.market_place_menu, menu)
                val searchItem = menu.findItem(R.id.app_bar_search)
                val searchView: SearchView = searchItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        query.orEmpty().let {
                            if (it.isNotEmpty()) {
                                viewModel.getProducts(it)
                            }
                        }
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        return true
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Validate and handle the selected menu item
                return true
            }

        }, viewLifecycleOwner)
    }

    private fun initObservers() {
        viewModel.marketPlaceItemsLiveData.observe(viewLifecycleOwner) { pagingData ->
            itemRecyclerViewAdapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? MarketPlaceListListener
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    interface MarketPlaceListListener {
        fun goToDetail(id: String)
    }
}