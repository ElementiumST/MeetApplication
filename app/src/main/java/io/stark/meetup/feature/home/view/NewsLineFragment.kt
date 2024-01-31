package io.stark.meetup.feature.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.stark.meetup.R
import io.stark.meetup.feature.home.viewmodel.NewsLineViewModel

class NewsLineFragment : Fragment() {

    companion object {
        fun newInstance() = NewsLineFragment()
    }

    private lateinit var viewModel: NewsLineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_line, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsLineViewModel::class.java)
        // TODO: Use the ViewModel
    }

}