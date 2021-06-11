package com.example.kotlinlesson4.ui.details

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.core.ui.BaseActivity
import com.example.kotlinlesson4.core.ui.BaseAdapter
import com.example.kotlinlesson4.extensions.showToast
import com.example.kotlinlesson4.extensions.visible
import com.example.kotlinlesson4.model.DetailsItem
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity(R.layout.activity_details),
    BaseAdapter.IBaseAdapterClickListener<DetailsItem> {

    private val detailsViewModel: DetailsViewModel by viewModel()
    private val adapter = DetailsPlaylistAdapter()

    override fun setupUI() {
        val finish = { _: View -> finish() }
        iv_arrow.setOnClickListener(finish)
        textView2.setOnClickListener(finish)
        recycler_view_details.adapter = adapter
        adapter.listener = this
        tv_title_details.text = title_details
        tv_video_series_details.text =  ("${itemCount.toString()} ${applicationContext.resources.getString(R.string.video)}")
    }

    override fun setupLiveData() {

        id?.let {
            detailsViewModel.fetchDetailsPlaylist(it)
        }

        detailsViewModel.detailsPlaylistLiveData.observe(this) {
            adapter.setData(it.items)
            tv_desc_details.text = it.items[0].snippet.description
        }

        detailsViewModel.isProgress.observe(this) { isProgress ->
            loading_details.visible = isProgress
        }
    }


    companion object {
        var id: String? = null
        var title_details: String? = null
        var itemCount: Int? = null
        fun newIntent(
            context: Context?, title: String, id: String, itemCount: Int
        ): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            this.title_details = title
            this.id = id
            this.itemCount = itemCount
            return intent
        }
    }

    override fun onClick(model: DetailsItem, position: Int) {
        showToast(model.snippet.title)
    }
}