package com.gtaskmanager.databaseroompractice

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromDatetoLong(value: Date): Long {

        return value.time
    }

    @TypeConverter
    fun fromLongDateto(value: Long): Date {

        return Date(value)
    }
}