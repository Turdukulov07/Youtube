package com.example.kotlinlesson4.ui.main

import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.core.ui.BaseActivity
import com.example.kotlinlesson4.core.ui.BaseAdapter
import com.example.kotlinlesson4.extensions.visible
import com.example.kotlinlesson4.local.AppPrefs
import com.example.kotlinlesson4.model.Items
import com.example.kotlinlesson4.ui.details.DetailsActivity
import com.example.kotlinlesson4.ui.main.MainViewModel
import com.example.kotlinlesson4.ui.main.PlaylistAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main),
    BaseAdapter.IBaseAdapterClickListener<Items> {
    private val mainViewModel: MainViewModel by viewModel()
    private val prefs: AppPrefs by inject()

    private val adapter = PlaylistAdapter()

    override fun setupUI() {
        recycler_view.adapter = adapter
        adapter.listener = this
    }

    override fun setupLiveData() {

        mainViewModel.fetchMainPlaylist()

        mainViewModel.mainPlaylistLiveData.observe(this) {
            adapter.setData(it.items.toMutableList())
        }

        mainViewModel.loading.observe(this) { load ->
            mainLoading.visible = load
        }

    }

    override fun onClick(model: Items, position: Int) {
        startActivity(
            DetailsActivity.newIntent(
                this,
                model.snippet.title,
                model.id,
                model.contentDetails.itemCount
            )
        )
    }
}

