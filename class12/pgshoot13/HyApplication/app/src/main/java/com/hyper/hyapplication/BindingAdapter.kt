package com.hyper.hyapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyper.hyapplication.model.ResultGetSearchMovie

@BindingAdapter("loadImage")
fun ImageUrl(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load(imageUrl)
        .centerCrop()
        .into(imageView)
}

@BindingAdapter("bindData")
fun bindData(recyclerView: RecyclerView, data: List<ResultGetSearchMovie.Item>?) {
    data?.let {
        val viewAdapter = recyclerView.adapter as? MovieAdapter
        viewAdapter?.resetData(data)
    }
}