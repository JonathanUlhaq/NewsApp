package com.lazday.news

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.lazday.news.source.network.networkModule
import com.lazday.news.source.news.repositoryModule
import com.lazday.news.source.presistence.databaseModule
import com.lazday.news.ui.bookmark.bookmarkModule
import com.lazday.news.ui.bookmark.bookmarkViewModel
import com.lazday.news.ui.home.homeModule
import com.lazday.news.ui.home.homeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApps : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            androidLogger()
            androidContext(this@NewsApps)
            modules(
                networkModule,
                repositoryModule,
                homeViewModel,
                homeModule,
                bookmarkModule,
                bookmarkViewModel,
                databaseModule
            )
        }
    }
}