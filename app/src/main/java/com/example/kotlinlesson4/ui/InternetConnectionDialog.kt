package com.example.kotlinlesson4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.kotlinlesson4.R
import kotlinx.android.synthetic.main.dialog_internet_disconnected.*

class InternetConnectionDialog(val listener: () -> Unit) : DialogFragment() {

    companion object {

        const val TAG = "InternetConnectionDialog"

        fun newInstance(listener: () -> Unit): InternetConnectionDialog {
            val args = Bundle()
            val fragment = InternetConnectionDialog(listener)
            fragment.arguments = args
            return fragment
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_internet_disconnected, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_retry.setOnClickListener {
            listener()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }
}