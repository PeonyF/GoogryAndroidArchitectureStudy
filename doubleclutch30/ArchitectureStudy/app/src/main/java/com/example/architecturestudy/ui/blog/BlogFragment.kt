package com.example.architecturestudy.ui.blog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturestudy.Injection
import com.example.architecturestudy.R
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : Fragment() {

    private lateinit var blogAdapter: BlogAdapter

    private val naverSearchRepository by lazy { Injection.provideNaverSearchRepository()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         blogAdapter = BlogAdapter()

        recycleview.apply {
            adapter = blogAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(
                DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            )
        }

        btn_search.setOnClickListener {
            if(input_text != null) {
                val edit = edit_text.text.toString()
                searchBlogList(edit)
            }
        }
    }

    private fun searchBlogList(keyWord: String) {

        naverSearchRepository.getBlog(
            keyword = keyWord,
            success = { blogAdapter.update(it) },
            fail = {e ->
                Log.e("test11", e.toString())
                Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT)
            }
        )
    }
}