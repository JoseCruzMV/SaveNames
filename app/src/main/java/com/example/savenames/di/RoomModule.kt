package com.example.savenames.di

import android.content.Context
import androidx.room.Room
import com.example.savenames.data.database.NameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val SAVE_NAME_DATABASE_NAME = "save_name_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            NameDatabase::class.java,
            SAVE_NAME_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideNameDao(db: NameDatabase) = db.getNameDao()

}