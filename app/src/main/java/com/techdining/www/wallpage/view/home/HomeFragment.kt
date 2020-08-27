package com.techdining.www.wallpage.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.techdining.www.wallpage.Injection
import com.techdining.www.wallpage.R
import com.techdining.www.wallpage.adapter.HomePageAdapter
import com.techdining.www.wallpage.databinding.FragmentHomeBinding
import com.techdining.www.wallpage.viewModel.HomeViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val adapter = HomePageAdapter()
    private var fetchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.photoList.adapter = adapter
        homeViewModel = ViewModelProvider(this, Injection.provideViewModelFactory())
            .get(HomeViewModel::class.java)

        fetchJob?.cancel()
        fetchJob = lifecycleScope.launch {
            homeViewModel.photosToBeDisplayed().collectLatest {
                adapter.submitData(it)
            }
        }

        return binding.root
    }
}