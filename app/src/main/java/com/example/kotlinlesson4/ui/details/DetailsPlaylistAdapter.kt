package com.example.kotlinlesson4.ui.details

import android.view.View
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.core.ui.BaseAdapter
import com.example.kotlinlesson4.extensions.loadImage
import com.example.kotlinlesson4.model.DetailsItem
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.item_playlist_details.view.*

class DetailsPlaylistAdapter : BaseAdapter<DetailsItem>(
    R.layout.item_playlist_details
) {
    override fun onBind(view: View, model: DetailsItem, position: Int) {
        view.run {
            image_view_details.loadImage(model.snippet.thumbnails.medium.url)
            tv_playlist_name_details.text = model.snippet.title
        }
    }
}