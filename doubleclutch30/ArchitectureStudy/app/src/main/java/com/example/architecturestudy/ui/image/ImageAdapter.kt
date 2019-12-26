package com.example.architecturestudy.ui.image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecturestudy.R
import com.example.architecturestudy.data.model.ImageItem
import com.example.architecturestudy.ui.startWebView
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    private val imageItem : MutableList<ImageItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageHolder(view).apply {
            itemView.setOnClickListener { v -> v.startWebView(imageItem[adapterPosition].link) }
        }
    }

    override fun getItemCount(): Int {
        return imageItem.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageItem[position])
    }

    fun update(imageList : List<ImageItem>) {
        this.imageItem.clear()
        this.imageItem.addAll(imageList)
        notifyDataSetChanged()
    }

    class ImageHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(item : ImageItem) {
            with(itemView) {
                Glide.with(this).
                    load(item.thumbnail).
                    error(R.drawable.ic_launcher_background).
                    into(img_image)
            }
        }

    }
}