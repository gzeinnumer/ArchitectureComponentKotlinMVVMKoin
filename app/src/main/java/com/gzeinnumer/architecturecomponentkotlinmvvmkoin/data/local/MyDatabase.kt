package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.CategoriesItem

@Database(entities = [CategoriesItem::class], version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao

    companion object {

        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        MyDatabase::class.java,
                        "prhases_database")
                        .allowMainThreadQueries()
                        .build()
            }

            return INSTANCE!!
        }
    }
}