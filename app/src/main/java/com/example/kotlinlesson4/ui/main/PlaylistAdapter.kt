package com.example.kotlinlesson4.ui.main

import android.view.View
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.core.ui.BaseAdapter
import com.example.kotlinlesson4.extensions.loadImage
import com.example.kotlinlesson4.model.Items
import kotlinx.android.synthetic.main.item_playlists.view.*

class PlaylistAdapter : BaseAdapter<Items>(
    R.layout.item_playlists
) {
    override fun onBind(view: View, model: Items, position: Int) {
        view.run {
            tv_playlist_name.text = model.snippet.title
            tv_video_series_details.text =
                ("${model.contentDetails.itemCount} ${view.context.resources.getString(R.string.video)}")
            image_view.loadImage(model.snippet.thumbnails.default.url)
        }
    }

}

