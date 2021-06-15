package com.gtaskmanager.databaseroompractice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {


    abstract fun contactDao(): ContactDAO

    companion object {
        @Volatile
        private var INTENCE: ContactDatabase? = null

        @InternalCoroutinesApi
        fun getdatabase(context: Context): ContactDatabase {
            if (INTENCE == null){
            synchronized(this){
                INTENCE =
                    Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java, "ContactDB")
                        .build()
            }
            }
            return INTENCE!!

        }
    }
}