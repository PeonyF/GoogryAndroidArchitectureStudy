package com.architecture.androidarchitecturestudy.adapter

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.architecture.androidarchitecturestudy.data.model.Movie
import com.architecture.androidarchitecturestudy.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.movie?.link))
            this.itemView.context.startActivity(intent)
        }
    }

    fun onBind(movieData: Movie) {
        binding.movie = movieData
        binding.executePendingBindings()
    }
}