package com.ithena.studentdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized


@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)

abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

        companion object {

       private var INSTANCE: StudentDatabase? = null

            fun getDatabase(context: Context): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }

}


