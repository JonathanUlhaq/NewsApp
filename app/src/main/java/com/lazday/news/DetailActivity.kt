package com.lazday.news

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.lazday.news.databinding.ActivityDetailBinding
import com.lazday.news.databinding.ActivityHomeBinding
import com.lazday.news.databinding.CustomToolbarBinding
import com.lazday.news.source.news.ArticleModel

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private lateinit var bindingToolbar: CustomToolbarBinding
    val detail  by lazy { intent.getSerializableExtra("DETAIL") as ArticleModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingToolbar = binding.toolbar
        setContentView(binding.root)


        bindingToolbar.title = "Berita"



        detail.let {
            val web = binding.webView
            web.loadUrl(it.url!!)
            val setting = binding.webView.settings
            setting.javaScriptCanOpenWindowsAutomatically = false
            web.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressTop.visibility =  View.GONE
                }
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bookmark,menu)
        val menuBookmark = menu!!.findItem(R.id.action_bookmark)
        menuBookmark.setOnMenuItemClickListener {
            menuBookmark.setIcon(R.drawable.ic_check)
            true
        }
        return super.onCreateOptionsMenu(menu)
    }



}