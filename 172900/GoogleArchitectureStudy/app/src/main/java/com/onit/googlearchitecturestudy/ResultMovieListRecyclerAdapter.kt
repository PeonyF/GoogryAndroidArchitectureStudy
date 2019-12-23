package com.onit.googlearchitecturestudy

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.holder_movie.view.*

class ResultMovieListRecyclerAdapter(
    private var list: List<Movie>,
    private val listener: MovieViewHolder.ClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_movie, parent, false)

        return MovieViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = list[position]
        with(holder as MovieViewHolder) {
            title.text = movie.title.removeTag()
            rating.rating = movie.userRating / 2f
            releaseDate.text = movie.releaseDate
            director.text = movie.director
            actor.text = movie.actor
            Glide.with(itemView).load(movie.posterImage).into(poster)
        }
    }

    fun setMovieList(newMovieList: List<Movie>) {
        list = newMovieList
        notifyDataSetChanged()
    }

    fun getMovieURL(position: Int): String {
        return list[position].link
    }

    class MovieViewHolder(itemView: View, private val listener: ClickListener) :
        RecyclerView.ViewHolder(itemView) {

        private val movieViewHolder = itemView.movieHolder
        var poster = itemView.posterImageView
        var title = itemView.titleTextView
        var rating = itemView.gradeRatingBar
        var releaseDate = itemView.releaseDateTextView
        var director = itemView.directorTextView
        var actor = itemView.actorsTextView

        init {
            movieViewHolder.setOnClickListener {
                listener.clickViewHolder(adapterPosition)
            }
        }

        interface ClickListener {
            fun clickViewHolder(position: Int)
        }
    }

    private fun String.removeTag(): String {
        return Html.fromHtml(this).toString()
    }
}