package com.lazday.news.source.presistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lazday.news.source.news.ArticleModel
import com.lazday.news.source.news.NewsDao
import com.lazday.news.util.SourceConverter

@Database(
    entities = [ArticleModel::class],
    version = 1,
    exportSchema = false

)
@TypeConverters(SourceConverter::class)
abstract  class DatabaseClien:RoomDatabase() {
    abstract val newsDAO:NewsDao
}