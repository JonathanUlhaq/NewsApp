package com.lazday.news.source.presistence

import android.app.Application
import androidx.room.Room
import com.lazday.news.source.news.NewsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideNews(get()) }
}

fun provideDatabase(aplication:Application):DatabaseClien {
    return Room.databaseBuilder(
        aplication,
        DatabaseClien::class.java,
        "dataBerita.db"
    ).fallbackToDestructiveMigration()
        .build()
}

fun provideNews(databseClien: DatabaseClien):NewsDao = databseClien.newsDAO