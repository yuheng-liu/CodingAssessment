package com.yuheng.codingassessment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuheng.codingassessment.databinding.ItemMovieBinding
import com.yuheng.codingassessment.models.Movie

class MovieAdapter: ListAdapter<Movie, MovieAdapter.MoviesViewHolder>(MovieDiffUtils()) {

    inner class MoviesViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            textViewTitle.text = data.Title
            textViewYear.text = data.Year
            Glide.with(holder.itemView)
                .load(data.Poster)
                .into(imageViewPoster)
        }
    }
}

private class MovieDiffUtils: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
}