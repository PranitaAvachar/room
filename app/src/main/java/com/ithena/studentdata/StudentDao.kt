package com.ithena.studentdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

   @Update
   suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("select * from students order by roll_no ASC")
    fun getAllStudents() : LiveData<List<Student>>



}