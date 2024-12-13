package com.yuheng.codingassessment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yuheng.codingassessment.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        setupAdapter()
        setupObservers()
        setupListeners()
    }

    private fun setupAdapter() {
        movieAdapter = MovieAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = movieAdapter
        }
    }

    private fun setupObservers() = lifecycleScope.launch {
        viewModel.movieInfoFlow.collect { movieInfo ->
            movieAdapter.submitList(movieInfo)
        }
    }

    private fun setupListeners() {
        binding.buttonGetMovieInfo.setOnClickListener {
            viewModel.searchMovie(binding.editTextMovieTitle.text.toString())
        }
    }
}